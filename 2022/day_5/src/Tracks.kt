import java.io.File
import java.io.BufferedReader

fun ReadFile(name: String): List<String> {
  val items: List<String> = File(name).readLines()
  return items
}

// amount == amount of line to read
fun Structure(all_lines: List<String>, amount: Int): MutableList<MutableList<Pair<Int, String>>> {
  var all_sets: MutableList<MutableList<Pair<Int, String>>> = mutableListOf()
  var single_set: MutableList<Pair<Int, String>> = mutableListOf()
  var letter: String = ""
  var counter: Int = 0
  for (i in 0..amount) {
    var position: Int = 0
    for (j in all_lines[i]) {
      if (j == ' ') {
        if (counter >= 3) {
          single_set.add(Pair(position, ""))
          ++position
          counter = 0
        } else {
          ++counter
        }
        continue
      }
  
      if (j >= 'A' && j <= 'Z') {
        letter += j
      }
  
      if (j == ']') {
        single_set.add(Pair(position, letter))
        letter = ""
        ++position
        counter = 0
      }
    }
    all_sets.add(single_set)
    single_set = mutableListOf()
  }
  
  return all_sets
}

fun Movement(list: MutableList<MutableList<Pair<Int, String>>>, amount: Int, from: Int, to: Int): List<MutableList<Pair<Int, String>>> {
  var counter: Int = 0
  var list_to_move: MutableList<Pair<Int, String>> = mutableListOf()
  list.forEach {
    for ((position, i) in it.withIndex()) {
      if (i.first == from) {
        list_to_move.add(i)
        ++counter
        it[position] = Pair(from, "")
        if (counter == amount) {
          break
        }
      }
    }
  }

  counter = 0
  for (i in list.size - 1 ..0) {
    if (list[i][to - 1].second == "") {
      list[i][to - 1] == list_to_move[counter]
      ++counter
    }
  }

  if (counter < list_to_move.size - 1) {
    for (i in 0..list_to_move.size - 1) {
      if (counter >= list_to_move.size - 1) {
        break
      }
      var list_to_change: MutableList<Pair<Int, String>> = mutableListOf()
      when (to) {
        0 ->  list_to_change = mutableListOf(Pair(0, list_to_move[counter].second), Pair(1, ""), Pair(2, ""))
        1 -> list_to_change =  mutableListOf(Pair(0, ""), Pair(1, list_to_move[counter].second), Pair(2, ""))
        2 -> list_to_change =  mutableListOf(Pair(0, ""), Pair(1, ""), Pair(2, list_to_move[counter].second))
        else -> println("There are a error with (" + to + ")")
      }
      list.add(0, list_to_change)
      ++counter
    }
  }

  return list
}

fun ReadMovement(AllLines: List<String>, All_tracks: MutableList<MutableList<Pair<Int, String>>>, start: Int) : List<MutableList<Pair<Int, String>>> {
  var switcher: Int = 0
  for (i in start..AllLines.size - 1) {
    var amount: Int = -100
    var from: Int = -100
    var to: Int = -100
    for (j in AllLines[i]) {
      if (j <= '9' && j >= '0') {
        when (switcher) {
          0 -> amount = j.toInt() - 48
          1 -> from = j.toInt() - 48
          2 -> to = j.toInt() - 48
          3 -> {
            Movement(All_tracks, amount, from, to)
            switcher = -1
          }
          else -> println("There are an error with switcher: (" + switcher + ")")
        }
        ++switcher
      }
    }
  }
  return All_tracks
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  val All_tracks: MutableList<MutableList<Pair<Int, String>>> = Structure(AllLines, args[1].toInt())
  val definitive: List<MutableList<Pair<Int, String>>> = ReadMovement(AllLines, All_tracks, args[1].toInt() + 1)
  println()
  println(definitive)
}