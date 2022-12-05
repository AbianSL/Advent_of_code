import java.io.File
import java.io.BufferedReader

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
  return items
}

fun Structure(all_lines: List<String>, amount: Int): List<MutableList<String>> {
  var all_sets: MutableList<MutableList<String>> = mutableListOf()
  var single_set: MutableList<String> = mutableListOf()
  var letter: String = ""
  var counter: Int = 0
  var position: Int = 0
  for (i in 0..all_lines.size - 1) {
    
    val number = all_lines[i].toList().filter{ it <= '9' && it >= '0' }
    if (number.size >= 1) {
      break
    }

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
        letter += j
      }
  
      if (j == ']') {
        println(position)
        println(letter)
        single_set.add(position, letter)
        letter = ""
        counter = 0
      }
    }
    all_sets.add(single_set)
  }
  return all_sets
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  val All_tracks: List<MutableList<String>> = Structure(AllLines, args[1])
}