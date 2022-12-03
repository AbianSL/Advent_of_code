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
  var first_group: MutableList<String> = mutableListOf()
  var second_group: MutableList<String> = mutableListOf()
  
  for (i in items ) {
    var word: String = ""
    for (j in 0..i.length - 1) {
      word += i[j]
      if (j == ((i.length - 1) / 2)) {
        first_group.add(word)
        word = ""
      }
    }
    second_group.add(word)
  }
  
  var char_list: MutableList<Char> = mutableListOf()
  for (i in 0..first_group.size - 1) {
    char_list.add(SearchForEqual(first_group[i], second_group[i]))
  }
  println(SumValue(char_list))
}