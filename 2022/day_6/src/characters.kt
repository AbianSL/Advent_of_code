import java.io.File
import java.io.BufferedReader

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  
}

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
  return items
}
