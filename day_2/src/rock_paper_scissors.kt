import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  var amount_cal: MutableList<String> = mutableListOf()

  File("data/advent.txt").useLines { 
    lines -> lines.forEach {
      amount_cal.add(sum)
    }
  }

  return amount_cal
}

fun main() {
  val calories: List<String> = ReadFile()
  calories.forEach {
    println(it)    
  }
}