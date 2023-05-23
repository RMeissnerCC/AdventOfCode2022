package aoc2022

import utils.loadData


class TreeNode(val path: String) {
    private val children: MutableList<TreeNode> = mutableListOf()
    var parent: TreeNode? = null

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
        var s = path
        if (!children.isEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }

    var size: Int = 0

    fun getChildren() = children
}

fun main() {
    val fileName = "src/main/resources/aoc2022/day7"
    val commands = loadData(fileName)
    val output = day7First(commands)
    println(output)
}
// use a tree like structure?
// parse with substring before command


fun day7First(commands: List<String>): Int {

    // TODO: Better use FileTreeWalk?!

    val fileSystem = parseFileSystem(commands)
    val smallDirectories = getSmallDirectories(fileSystem)
    return smallDirectories.totalSize()
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

        }
    }
    return fileSystem

}

fun List<TreeNode>.totalSize() = this.size
fun getSmallDirectories(fileSystem: TreeNode): List<TreeNode> {
    println(fileSystem)
    return listOf<TreeNode>()
}
