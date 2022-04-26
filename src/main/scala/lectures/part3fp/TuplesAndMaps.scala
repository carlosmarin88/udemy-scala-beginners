package lectures.part3fp

object TuplesAndMaps extends App {

  //tuples = finite order "lists"
  val aTuple = (2, "Hello, Scala") // Tuple[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("Hello, Scala", 2)

  //  Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  //return value -1 when key not exit

  //a -> b is sugar for (a, b)
  println(phonebook)
  println(phonebook.get("Jim"))

  //  map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary")) // phonebook.get("Mary")

  //  add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  //  functionals on maps
  //  map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  //  filterKeys
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)

  // mapValues
  println(phonebook.view.mapValues(number => "0245-" + number).toMap)

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
