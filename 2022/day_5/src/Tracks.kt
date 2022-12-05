import java.io.File
import java.io.BufferedReader

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
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
        // all_sets.add(0, letter)
        letter = ""
      }
    }
  }
  return all_sets
}

fun Usage(args: Array<String>) {
  if (args.size != 2) {
    println("there is not enough parameter")
  }
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
}