import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  val items: List<String> = File("data/advent.txt").readLines()
  return items
}

fun SearchForEqual(first_group: String, second_group: String): Char {
  for (i in first_group) {
    for (j in second_group) {
      if (i == j) {
        return i
      }
    }
  }
  return '.'
}

fun SearchForEqual(first_group: String, second_group: String, third_group: String): Char {
  for (i in first_group) {
    for (j in second_group) {
      for (k in third_group) {
        if (i == j && i == k) {
          return i
        }  
      }
    }
  }
  return '.'
}

fun CharValue(symbol: Char): Int {
  if (symbol >= 'a' && symbol <= 'z') {
    return (symbol.toInt() - 96)
  } else if (symbol >= 'A' && symbol <= 'Z') {
    return (symbol.toInt() - 38)
  } else {
    return -100000
  }
}

fun SumValue(char_list: MutableList<Char>): Int {
  var sum: Int = 0
  for (i in char_list) {
    sum += CharValue(i)
  }
  return sum
}

fun main() {
  val items: List<String> = ReadFile()
  
  var amount_group: MutableList<String> = mutableListOf()
  var all_groups: MutableList<MutableList<String>> = mutableListOf()
  var counter: Int = 0
  for (i in items) {
    ++counter
    amount_group.add(i)
    if ((counter % 3) == 0 ) {
      all_groups.add(amount_group)
      amount_group = mutableListOf()
    }
  }

  var char_list: MutableList<Char> = mutableListOf()
  for (i in all_groups) {
    char_list += SearchForEqual(i[0], i[1], i[2])
  }

  println(SumValue(char_list))
}