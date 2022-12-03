import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<Int> {
  var amount_cal: MutableList<Int> = mutableListOf()
  var sum: Int = 0

  File("data/advent.txt").useLines { 
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

fun WhichIsBigger(ListToSearch: List<Int>): Int {
  var bigger = 0

  for (i in ListToSearch) {
    if (i > bigger) {
      bigger = i
    }
  }
  
  return bigger
}

fun TopThree(ListToSearch: List<Int>): Int {
  var third: Int = 0
  var second: Int = 0
  var first: Int = 0

  for (i in ListToSearch) {
    if (i > first) {
      third = second
      second = first
      first = i
    } else if (i > second) {
      third = second
      second = i
    } else if (i > third) {
      third = i
    }
  }

  return first + second + third
}


fun main() {
  val calories: List<Int> = ReadFile()
  println(TopThree(calories))
}