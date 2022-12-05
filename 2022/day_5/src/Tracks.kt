import java.io.File
import java.io.BufferedReader

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
  return items
}

// amount == amount of line to read
fun Structure(all_lines: List<String>, amount: Int): List<MutableList<String>> {
  var all_sets: MutableList<MutableList<String>> = mutableListOf()
  var single_set: MutableList<String> = mutableListOf()
  var letter: String = ""
  var counter: Int = 0
  var position_should_be: Int = 0
  var position: Int = 0
  for (i in 0..amount) {
    for (j in all_lines[i]) {
      if (j == ' ') {
        if (counter >= 3) {
          ++position
          if (position > position_should_be) {
            break
          }
          counter = 0
        } else {
          ++counter
        }
        continue
      }
  
      if (j >= 'A' && j <= 'Z') {
        letter += j
      }
  
      if (j == ']') {
        single_set.add(letter)
        letter = ""
        counter = 0
      }
    }
    if (i >= amount) {
      all_sets.add(single_set)
      single_set = mutableListOf()
      i = -1
    }
  }
  return all_sets
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  val All_tracks: List<MutableList<String>> = Structure(AllLines, args[1])
}