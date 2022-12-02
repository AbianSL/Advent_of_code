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
  
}

fun main() {
  val calories: List<String> = ReadFile()
  var first_value: String = "" 
  var second_value: String = "" 

  calories.forEach {
    var fist_second: Boolean = 1
    for (i in 0..it.length-1) {
      if (fist_second) {
        first_value = it[i]
        first_second = 0
      } else if (it[i] != '') 
        second_value = it[i]
      }
    }
    sum_puntuation(first_value, second_value)
  }
}