package aoc2022

import utils.loadData
import kotlin.math.abs


class TreeNode(val path: String) {
    private val children: MutableList<TreeNode> = mutableListOf()
    var parent: TreeNode? = null
    var isFile: Boolean = false

    fun add(node: TreeNode) {
        children.add(node)
        node.parent = this
    }

    fun addChild(path: String): TreeNode {
        val node = TreeNode(this.path + path)
        children.add(node)
        node.parent = this
        return node
    }

    override fun toString(): String {
        var s = "$path: $size"
        if (!children.isEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }

    var size: Int = 0

    private fun childrenSizes(): Int {
        return if (children.size == 0) size
        else children.sumOf { it.childrenSizes() }
    }

    fun calculateSizes() {
        size = childrenSizes()
        children.map { it.calculateSizes() }
    }

    fun getChildren() = children

    fun flatten(): List<TreeNode> {
        return children.map { it.flatten() }.flatten() + this
    }
}

fun main() {
    val fileName = "src/main/resources/aoc2022/day7"
    val commands = loadData(fileName)
    day7First(commands).also { println(it) }
    day7Second(commands).also { println(it) }
}


fun day7First(commands: List<String>): Int {
    val fileSystem = parseFileSystem(commands)
    return getSmallDirectories(fileSystem, 100_000).totalSize()
}

fun day7Second(commands: List<String>): Int {
    val fileSystem = parseFileSystem(commands)
    val requiredSpaceToFree = 8_381_165
    return getSmallDirectories(fileSystem).findSuitablySmallFolder(requiredSpaceToFree)
}

fun parseFileSystem(commands: List<String>): TreeNode {
    val fileSystem = TreeNode("/")
    var currentNode = fileSystem

    for (line in commands) {
        if (line.startsWith("\$")) {
            val commandLine = line.substringAfter("\$ ")
            if (commandLine.contains("cd")) {
                currentNode = when (commandLine.substringAfter(" ")) {
                    "/" -> fileSystem
                    ".." -> (if (currentNode.parent == null) fileSystem else currentNode.parent)!!
                    else -> currentNode.addChild(commandLine.substringAfter(" ") + "/")
                }
            }
        } else if (line.substringBefore(" ") != "dir") {
            val file = currentNode.addChild(line.substringAfter(" "))
            file.size = line.substringBefore(" ").toInt()
            file.isFile = true

        }
    }
    fileSystem.calculateSizes()
    return fileSystem

}

fun List<TreeNode>.totalSize() = this.sumOf { it.size }

fun List<TreeNode>.findSuitablySmallFolder(neededSpace: Int): Int
{
    var min = Int.MAX_VALUE
    var closest: Int = neededSpace

    for (v in this) {
        val diff: Int = abs(v.size - neededSpace)
        if (diff < min && v.size >= neededSpace) {
            min = diff
            closest = v.size
        }
    }
    return closest
}
fun getSmallDirectories(fileSystem: TreeNode, minimumSize: Int = Int.MAX_VALUE): List<TreeNode> {
    return fileSystem.flatten().filter { it.size < minimumSize && !it.isFile }
}
