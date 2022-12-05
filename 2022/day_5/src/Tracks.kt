import java.io.File
import java.io.BufferedReader

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
  return items
}

// amount == amount of line to read
fun Structure(all_lines: List<String>, amount: Int): List<MutableList<Pair<Int, String>>> {
  var all_sets: MutableList<MutableList<Pair<Int, String>>> = mutableListOf()
  var single_set: MutableList<Pair<Int, String>> = mutableListOf()
  var letter: String = ""
  var counter: Int = 0
  for (i in 0..amount) {
    var position: Int = 0
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
        single_set.add(Pair(position, letter))
        letter = ""
        ++position
        counter = 0
      }
    }
    all_sets.add(single_set)
    single_set = mutableListOf()
  }
  println(all_sets)
  
  return all_sets
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  val All_tracks: List<MutableList<Pair<Int, String>>> = Structure(AllLines, args[1].toInt())
}