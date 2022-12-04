import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  val items: List<String> = File("data/example.txt").readLines()
  return items
}

fun SeparateInPairs(line: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
  var first_value: Int = -1000
  var second_value: Int = -1000
  var first_second: Boolean = true 
  var first_pair = Pair(-100, -100) // to know if it doens't do
  var second_pair = Pair(-100, -100) // to know if it doens't do
  var first_second_pair: Boolean = true
  for (i in line) {
    if (i >= '0' && i <= '9') {
      if (first_second) {
        first_value = i.toInt() - 48
        first_second = false
      } else {
        second_value = i.toInt() - 48 // to ASCII to normal numbers
        first_second = true
      }
    } 
    if (i == ',' || i == line[line.length - 1]) {
      if (first_second_pair) {
        first_pair = Pair(first_value, second_value)
        first_second_pair = false
      } else {
        second_pair = Pair(first_value, second_value)
      }
    }
  }
  return Pair(first_pair, second_pair)
}

fun ItCountainOthers(pair_other: Pair<Int,Int>, list_pairs: MutableList<Pair<Pair<Int, Int>, Pair<Int, Int>>>): Boolean {
  for (i in list_pairs) {
    for (j in i.toList()) {
      if ((j.second <= pair_other.second) && (j.first >= pair_other.first)) {
        return true
      }
    }
  }
  return false
}

fun HowManyContainsOthers(list_pairs: MutableList<Pair<Pair<Int, Int>, Pair<Int, Int>>>): Int {
  var counter: Int = 0
  for (i in list_pairs) {
    for (j in i.toList()) {
      if (ItCountainOthers(j, list_pairs)) {
        ++counter
      }
    }
  }
  return counter
}

fun main() {
  val All_lines: List<String> = ReadFile()
  var list_pairs: MutableList<Pair<Pair<Int, Int>, Pair<Int, Int>>> = mutableListOf()
  for (i in All_lines) {
    val Each_pair: Pair<Pair<Int, Int>, Pair<Int, Int>> = SeparateInPairs(i)
    list_pairs.add(Each_pair)
  }
  println(HowManyContainsOthers(list_pairs))
}