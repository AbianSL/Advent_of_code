import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  val items: List<String> = File("data/example.txt").readLines()
  return items
}

fun Structure(all_lines: List<String>): List<MutableList<String>> {
  var all_sets: MutableList<MutableList<String>> = mutableListOf()
  var letter: String = ""
  for (i in 0..all_lines.size - 1) {
    for (j in all_lines[i]) {
      if (j == ' ') {
        continue
      }
  
      if (j >= 'A' && j <= 'Z') {
        letter += j
      }
  
      if (j == ']') {
        all_sets.add(0, letter)
        letter = ""
      }
    }
  }
}

fun main() {
  val All_lines: List<String> = ReadFile()
}