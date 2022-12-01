import java.nio.file.Files
import java.nio.file.Paths

fun ReadFile():List<Int> {
  var amount_cal: List<Int>
  val path = Paths.get("home/tara/Escritorio/Personal/Advent_of_code")
  var sum:Int = 0
  Files.readAlllines(path, Charsets.UTF_8).foreach {
    if (it == "") {
      amount_cal.add(sum)
      sum = 0
    } else {
      sum += it
    }
  } 
  return amount_cal
}

fun main() {
  val calories: List<Int> = ReadFile()
}