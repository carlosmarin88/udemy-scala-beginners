package lectures.part3fp

object AnonymousFunctions extends App{

  //anonymous function (LAMBDA)
  val doubler: Int => Int = (x: Int) => x * 2

  //multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no params
  val justDoSomething: () => Int = () => 3

  //  careful
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  //  curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //  MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) =>  Int = _ + _ // equivalent to (a, b) => a + b

  /*
  *  2. Rewrite the "special" adder as an anonymous function
  * */
/*
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int):Function1[Int, Int] = new Function1[Int, Int]{
      override def apply(y: Int): Int = x + y
    }
  }
*/
  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(4))
}
