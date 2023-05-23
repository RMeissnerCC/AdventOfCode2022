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

    var size: Int
        get() = 0
        set(value) {
            value // parses the string and assigns values to other properties
        }

    fun getChildren() = children
}

fun main() {
    val fileName = "src/main/resources/aoc2022/day7"
    val commands = loadData(fileName)
    var output = day7First(commands)
    println(output)
}
// use a tree like structure?
// parse with substring before command


fun day7First(commands: List<String>): Int {

    // TODO: Better use FileTreeWalk?!

    var fileSystem = parseFileSystem(commands)

    var smallDirectories = getSmallDirectories(fileSystem)
    return smallDirectories.totalSize()
}

fun parseFileSystem(commands: List<String>): TreeNode {
    var fileSystem = TreeNode("/")
    var currentDirectory = "/"
    var currentNode = fileSystem;

    for (line in commands) {
        if (line.startsWith("\$")) {
            val commandLine = line.substringAfter("\$ ")
            if (commandLine.contains("cd")) {
                currentNode = when (commandLine.substringAfter(" ")) {
                    "/" -> fileSystem;
                    ".." -> (if (currentNode.parent == null) fileSystem else currentNode.parent)!!;
                    else -> currentNode.addChild(commandLine.substringAfter(" ") + "/")
                }
            }
        } else {
            println("Printout: $line")
            if (line.substringBefore(" ") != "dir") {
                // file found
                println("File found: $line.")

            }
        }
        println("Current dir: $currentDirectory and CurrentNode: $currentNode")
    }
    return fileSystem

}

fun List<TreeNode>.totalSize() = this.size
fun getSmallDirectories(fileSystem: TreeNode): List<TreeNode> {
    println(fileSystem)
    return listOf<TreeNode>()
}
