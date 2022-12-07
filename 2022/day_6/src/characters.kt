import java.io.File
import java.io.BufferedReader

fun AllDifferent(characters: String): Boolean {
  for (i in 0..characters.length - 1) {
    for (j in 0..characters.length - 1) {
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

fun HowManyTakeFour(line: List<String>): Int {
  for (i in line) {
    for (k in 0..i.length - 1) {
      var characters: String = ""
      var amount: Int = 0
      for (j in 0..3) {
        if (i.length - k < 4) {
          break
        }
        characters += i[k + j]
        amount = k + j + 1
      }

      if (AllDifferent(characters)) {
        return amount
      }
    }
  }
  return -1000
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  println(HowManyTakeFour(AllLines))
}

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
  return items
}
