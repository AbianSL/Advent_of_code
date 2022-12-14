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
      if ((i.first == from && i.second != "") &&
          (counter < amount)) {
        list_to_move.add(i)
        // modification
        // list_to_move.add(0, i)
        ++counter
        it[position] = Pair(from, "")
        if (counter >= amount) {
          break
        }
      }
    }
  }

  counter = 0
  for (i in (list.size - 1) downTo 0) {
    if (counter >= list_to_move.size) {
      break
    }
    if (list[i][to].second == "") {
      list[i][to] = Pair(list[i][to].first, list_to_move[counter].second)
      ++counter
    }
  }

  if (counter < list_to_move.size) {
    for (i in 0..list_to_move.size - 1) {
      if (counter >= list_to_move.size) {
        break
      }
      var list_to_change: MutableList<Pair<Int, String>> = mutableListOf()
      when (to) {
        0 -> list_to_change = mutableListOf(Pair(0, list_to_move[counter].second), Pair(1, ""), Pair(2, ""), Pair(3, ""), Pair(4, ""), Pair(5, ""), Pair(6, ""), Pair(7, ""), Pair(8, ""))
        1 -> list_to_change = mutableListOf(Pair(0, ""), Pair(1, list_to_move[counter].second), Pair(2, ""), Pair(3, ""), Pair(4, ""), Pair(5, ""), Pair(6, ""), Pair(7, ""), Pair(8, ""))
        2 -> list_to_change = mutableListOf(Pair(0, ""), Pair(1, ""), Pair(2, list_to_move[counter].second), Pair(3, ""), Pair(4, ""), Pair(5, ""), Pair(6, ""), Pair(7, ""), Pair(8, ""))
        3 -> list_to_change = mutableListOf(Pair(0, ""), Pair(1, ""), Pair(2, ""), Pair(3, list_to_move[counter].second), Pair(4, ""), Pair(5, ""), Pair(6, ""), Pair(7, ""), Pair(8, ""))
        4 -> list_to_change = mutableListOf(Pair(0, ""), Pair(1, ""), Pair(2, ""), Pair(3, ""), Pair(4, list_to_move[counter].second), Pair(5, ""), Pair(6, ""), Pair(7, ""), Pair(8, ""))
        5 -> list_to_change = mutableListOf(Pair(0, ""), Pair(1, ""), Pair(2, ""), Pair(3, ""), Pair(4, ""), Pair(5, list_to_move[counter].second), Pair(6, ""), Pair(7, ""), Pair(8, ""))
        6 -> list_to_change = mutableListOf(Pair(0, ""), Pair(1, ""), Pair(2, ""), Pair(3, ""), Pair(4, ""), Pair(5, ""), Pair(6, list_to_move[counter].second), Pair(7, ""), Pair(8, ""))
        7 -> list_to_change = mutableListOf(Pair(0, ""), Pair(1, ""), Pair(2, ""), Pair(3, ""), Pair(4, ""), Pair(5, ""), Pair(6, ""), Pair(7, list_to_move[counter].second), Pair(8, ""))
        8 -> list_to_change = mutableListOf(Pair(0, ""), Pair(1, ""), Pair(2, ""), Pair(3, ""), Pair(4, ""), Pair(5, ""), Pair(6, ""), Pair(7, ""), Pair(8, list_to_move[counter].second))
        else -> println("There are a error with the direction (" + to + ")")
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
    var string_p: String = ""
    for ((counter, j) in AllLines[i].withIndex()) {
      if (j <= '9' && j >= '0') {
        when (switcher) {
          0 -> {
            if (AllLines[i][counter + 1] <= '9' && 
                AllLines[i][counter + 1] >= '0') {
              switcher = -1
            }
            string_p += j
          }
          
          1 ->{
          amount = string_p.toInt()
          from = j.toInt() - 48 - 1 // I count since 0
          }   
          
          2 -> {
            to = j.toInt() - 48 - 1 // I count since 0            
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

fun Searcher(definitive: List<MutableList<Pair<Int, String>>>) : List<Pair<Int, String>> {
  var list_voc: MutableList<Pair<Int, String>> = mutableListOf()
  for (i in definitive) {
    var next: Boolean = false
    for (j in i) {
      for (k in list_voc) {
        if (k.first == j.first) {
          next = true
        }
      }

      if (next) {
        next = false
        continue
      }

      if (j.second != "") {
        list_voc.add(j)
      }
      next = false
    }
  }
  return list_voc
}

fun main(args: Array<String>) {
  val AllLines: List<String> = ReadFile(args[0])
  val All_tracks: MutableList<MutableList<Pair<Int, String>>> = Structure(AllLines, args[1].toInt())
  val definitive: List<MutableList<Pair<Int, String>>> = ReadMovement(AllLines, All_tracks, args[1].toInt() + 2)
  println()
  println(Searcher(definitive))
  
}