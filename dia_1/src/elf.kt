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

fun WhichIsBigger(ListToSearch: List<Int>): Int {
  var bigger = 0

  for (i in ListToSearch) {
    if (i > bigger) {
      bigger = i
    }
  }
  
  return bigger
}


fun main() {
  val calories: List<Int> = ReadFile()
  println(WhichIsBigger(calories))
}