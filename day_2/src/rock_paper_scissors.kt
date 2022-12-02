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
    "X" -> 1 // rock
    "Y" -> 2 // paper
    "Z" -> 3 // scissors
    else -> -1
  }

  sum += when (first) {
    "A" -> when (second) { // rock
      "X" -> 3  // rock
      "Y" -> 6  // paper
      "Z" -> 0  // scissors
      else -> -1
    }
    
    "B" -> when (second) { // paper
      "X" -> 0 // rock
      "Y" -> 3 // paper
      "Z" -> 6 // scissors
      else -> -1
    }
    
    "C" -> when (second) { // scissors
      "X" -> 6 // rock
      "Y" -> 0 // paper
      "Z" -> 3 // scissors
      else -> -1
    }
    else -> -1
  }

  return sum
}

fun if_won_loos(first: String, second: String): Int {
  return when (second) {
    "X" -> when (first) {
      "A" -> sum_puntuation(first, "Z")
      "B" -> sum_puntuation(first, "X")
      "C" -> sum_puntuation(first, "Y")
      else -> sum_puntuation(first, "-1")
    }

    "Y" -> when (first) {
      "A" -> sum_puntuation(first, "X")
      "B" -> sum_puntuation(first, "Y")
      "C" -> sum_puntuation(first, "Z")
      else -> sum_puntuation(first, "-1")
    }

    "Z" -> when (first) {
      "A" -> sum_puntuation(first, "Y")
      "B" -> sum_puntuation(first, "Z")
      "C" -> sum_puntuation(first, "X")
      else -> sum_puntuation(first, "-1")
    }

    else -> -1
  }
}

fun main() {
  val calories: List<String> = ReadFile()
  var sum_of_puntuation: Int = 0

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
    sum_of_puntuation += 
      
  }
  println(sum_of_puntuation)
}