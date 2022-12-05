import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  val items: List<String> = File("data/advent.txt").readLines()
  return items
}

fun Structure(all_lines: List<String>): List<MutableList<String>> {
  var all_sets: MutableList<MutableList<String>> = mutableListOf()
  var letter: String = ""
  for (i in all_lines) {
    if (i == ' ') {
      continue
    }

    if (i >= 'A' && i <= 'Z') {
      letter += i
    }

    if (i == ']') {
      all_sets.add(0, i)
      letter = ""
    }
  }
}

fun main() {
  val All_lines: List<String> = ReadFile()
}