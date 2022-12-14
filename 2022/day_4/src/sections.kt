import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  val items: List<String> = File("data/advent.txt").readLines()
  return items
}

fun SeparateInPairs(line: String): Pair<Pair<Int, Int>, Pair<Int, Int>> {
  var first_value: Int = -1000
  var second_value: Int = -1000
  var value: String = ""
  var first_second: Boolean = true 
  var first_pair = Pair(-100, -100) // to know if it doens't do
  var second_pair = Pair(-100, -100) // to know if it doens't do
  var first_second_pair: Boolean = true
  for (i in 0..line.length - 1) {
    if (line[i] >= '0' && line[i] <= '9') {
      value += line[i]
    } 

    if (line[i] == '-' || line[i] == ',' || i == (line.length - 1)) {
      if (first_second) {
        first_value = value.toInt()
        first_second = false
      } else {
        second_value = value.toInt()
        first_second = true
      }
      value = ""
    }

    if (line[i] == ',' || i == (line.length - 1)) {
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

fun ItCountainOther(first_pair: Pair<Int,Int>, other_pair: Pair<Int, Int>): Boolean {
  if ((first_pair.second <= other_pair.second) && (first_pair.first >= other_pair.first)) {
    return true
  } else if ((other_pair.second <= first_pair.second) && (other_pair.first >= first_pair.first)) {
    return true
  }
  return false
}

fun ItOverlap(first_pair: Pair<Int,Int>, other_pair: Pair<Int, Int>): Boolean {
  for (i in first_pair.first..first_pair.second) {
    for (j in other_pair.first..other_pair.second) {
      if (i == j) {
        return true
      }
    }
  }
  return false
}

fun HowManyContainsOthers(list_pairs: MutableList<Pair<Pair<Int, Int>, Pair<Int, Int>>>): Int {
  var counter: Int = 0
  for (i in list_pairs) {
    if (ItOverlap(i.first, i.second)) {
      ++counter
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