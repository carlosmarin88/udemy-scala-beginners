package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String,val age: Int = 0){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is handing out with ${person.name}"
    def +(nickname: String) : Person = new Person(s"$name (${nickname})", favoriteMovie)
    def unary_! : String = s"${name}, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def learns(learn: String): String = s"$name learns $learn"
    def learnsScala: String = learns("Scala")
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(numb: Int): String = s"${name} watched ${favoriteMovie} ${numb} times"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes ("Inception")) // equivalent
  // infix notation = operator notation (synctatic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS
  //AKKA actors have ! ?

  //prefix notation
  val x = -1 //equivalent with 1.unary_-
  // unary_prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) // equivalent

   val maryWithNickname: Person = mary + "the rockstar"
  println(maryWithNickname.name)
  println((+mary).age)

  println(mary learnsScala)

  println(mary(2))
}
