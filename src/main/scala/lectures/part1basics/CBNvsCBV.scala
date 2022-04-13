package lectures.part1basics

/**
 * call by name and call by value
 */
object CBNvsCBV extends App {

  def calledByValue(x: Long):Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //println(infinite(), 34) // error stackoverflow
  println(34, infinite)
}
