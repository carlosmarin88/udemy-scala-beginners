package lectures.part4pm

import exercises.{Cons, Empty, MyList2}

object AllThePatterns extends App {

  // 1 - constants

  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  //  2 - match anything
  //  2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  //  2.2 variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }

  //  3 - tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) => println("Nothing..")
    case (something, 2) => s"I've found $something"
  }

  println(matchATuple)

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case(_, (2, v)) => s"found match ${v}"
  }
  //  PM can be NESTED!

  // 4 - case classes - constructor pattern
  // PM can be nested with CCs as well

  val aList: MyList2[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }
}
