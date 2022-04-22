package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this ^^ will crash with a NPE

  // throwing and catching exceptions

  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try{
    //code that might throw
    getInt(true)
  }catch {
    case e: RuntimeException => println("caught a runtime exception")
  }finally {
    // code that will get executed NO MATTER WHAT
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  /*
  *   1. Crash you program with an OutOfMemoryError
  *   2. Crash with SOError
  *   3. PocketCalculator
  *     - add(x,y)
  *     - subtract(x, y)
  *     - multiply(x , y)
  *     - divide(x, y)
  *
  *   Throw
  *     - OverFlowException if add(x, y) exceeds Int.MAX_VALUE
  *     - UnderFlowException if subtract(x, y) exceeds Int.MIN_VALUE
  *     - MathCalculationException for division by 0
  * */

  //  1. OOM
  // val array = Array.ofDim(Int.MaxValue)

  //  SO
  //def infinite: Int = 1 + infinite
  //val noLimit = infinite

}
