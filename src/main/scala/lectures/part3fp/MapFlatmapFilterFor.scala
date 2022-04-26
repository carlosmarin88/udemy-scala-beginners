package lectures.part3fp

object MapFlatmapFilterFor extends App{

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  //  map
  println("map: " + list.map(_ + 1))
  println("map: " + list.map(_ + " is a number"))

  // filter
  println("filter: " + list.filter(_ % 2 ==0))

  //flatMap
  val toPair = (x: Int) => List(x, x+1)
  println("flatMap: " + list.flatMap(toPair))

  //print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")
  //my solution
  println("Exercise 1")
  println("My solution")
  println(chars.flatMap((char: Char) => numbers.map( (numb: Int) => s"$char$numb")))
  println("Solution teacher")
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  println("other combination")
  val combinations2 =  numbers.flatMap(n =>
    chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations2)

  //  foreach
  println("foreach")
  list.foreach(println)

  //  for-comprehensions
  println("for-comprehensions")
  val forCombinations = for {
    n <- numbers if n% 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  //syntax overload
  println("syntax overload")
  println( list.map { x =>
    x * 2
  })

}
