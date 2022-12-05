import java.io.File
import java.io.BufferedReader

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
  return items
}

fun Structure(all_lines: List<String>, amount: Int): List<MutableList<String>> {
  var all_sets: MutableList<MutableList<String>> = mutableListOf()
  var letter: Char = ''
  var counter: Int = 0
  var position: Int = 0
  for (i in 0..all_lines.size - 1) {
    for (j in all_lines[i]) {
      if (j == ' ') {
        if (counter >= 3) {
          ++position
          counter = 0
        } else {
          ++counter
        }
        continue
      }
  
      if (j >= 'A' && j <= 'Z') {
        letter = j
      }
  
      if (j == ']') {
        // all_sets.add(0, letter)
        letter = ''
      }
    }
  }
  return all_sets
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  
}