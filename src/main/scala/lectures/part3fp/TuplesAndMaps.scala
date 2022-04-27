package lectures.part3fp

import scala.annotation.tailrec

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

  println(Map(("Jim", 555), "JIM" -> 789)
    .map(pair => pair._1.toLowerCase -> pair._2))

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA = network(personA)
    val friendsB = network(personB)

    network + (personA -> (friendsA + personB)) + (personB -> (friendsB + personA))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String) = {

    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String) = {

    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if(friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unfriends = removeAux(network(person), network)
    unfriends - person
  }

  val empty: Map[String, Set[String]] = Map()
  println("Add")
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println("Friend")
  println(friend(network, "Bob", "Mary"))
  println("Unfriend")
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println("Remove Bob")
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  // Jim, Bob, Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")
  println("Jim, Bob, Mary")
  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if(!network.contains(person)) 0
    else network(person).size
  }

  println("Count friends have Bob")
  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  println("Who has more friends?")
  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    //network.keys.filter(k => network(k).isEmpty).size
    //network.count(pair => pair._2.isEmpty)
    network.count(_._2.isEmpty)
  }
  println("how many people do not have relationship?")
  println(nPeopleWithNoFriends(testNet))

  // if there is a social connection between two people (direct or not)
  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean ={
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean ={
      if(discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if(person == target) true
        else if(consideredPeople.contains(person))
            bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }

  println("Exist connection between Mary and Jim")
  println(socialConnection(testNet, "Mary", "Jim"))
  println("Exist connection between Mary and Bob")
  println(socialConnection(network, "Mary", "Bob"))


}

