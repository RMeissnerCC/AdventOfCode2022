package utils

import java.io.File


fun loadData(filename: String): List<String> {
    return File(filename).bufferedReader().readLines()
}