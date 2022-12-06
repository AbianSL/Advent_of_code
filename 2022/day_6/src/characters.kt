import java.io.File
import java.io.BufferedReader

fun AllDifferent(characters: String): Boolean {
  for (i in 0..characters.lenght) {
    for (j in 0..characters.lenght) {
      if (i == j) {
        continue
      }
      if (characters[i] == characters[j]) {
        return false
      }
    }
  }
  return true
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  
}

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
  return items
}
