import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<Int> {
  var amount_cal: MutableList<Int> = mutableListOf()
  var sum: Int = 0

  File("data/input.txt").useLines { 
    lines -> lines.forEach {
      if ( it == "" ) {
        amount_cal.add(sum)
        sum = 0
      } else {
        sum += it.toInt()
      }
    }
  }
  if (sum != 0) {
    amount_cal.add(sum)
  }

  return amount_cal
}

fun main() {
  val calories: List<Int> = ReadFile()
  println(calories)
}