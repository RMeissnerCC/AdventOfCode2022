import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

fun main() {
    val csvFile = "src/main/resources/day1"
    val reader = FileReader(csvFile, StandardCharsets.UTF_8)
    var lines = reader.readLines()
    lines.forEach({ println(it) })
    reader.close()
}