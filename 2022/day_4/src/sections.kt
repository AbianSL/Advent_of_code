import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  val items: List<String> = File("data/advent.txt").readLines()
  return items
}

fun SeparateInPairs(line: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
  var first_value = 0
  var second_value = 0
  for (i in line) {

  }
}

fun main() {
  val items: List<String> = ReadFile()
  
}