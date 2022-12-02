import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  var amount_cal: MutableList<String> = mutableListOf()

  File("data/example.txt").useLines { 
    lines -> lines.forEach {
      amount_cal.add(it)
    }
  }

  return amount_cal
}

fun sum_puntuation(first: String, second: String): Int {
  var sum: Int = 0
  sum += when (second) {
    "X" -> 1
    "Y" -> 2
    "Z" -> 3
    else -> -1
  }
  
  return sum
}

fun main() {
  val calories: List<String> = ReadFile()

  calories.forEach {
    var first_value: String = "" 
    var second_value: String = "" 
    var first_second: Boolean = true

    for (i in 0..it.length-1) {
      if (first_second) {
        first_value += it[i]
        first_second = false
      } else if (it[i] != ' ') {
        second_value += it[i]
      }
    }
    println(sum_puntuation(first_value, second_value))
  }
}