import java.io.File
import java.io.BufferedReader

fun ReadFile(): List<String> {
  val items: List<String> = File("data/advent.txt").readLines()
  return items
}

fun main() {
  val All_lines: List<String> = ReadFile()

}