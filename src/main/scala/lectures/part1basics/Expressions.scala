package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  var aVariable = 1;

  val aWeirdValue = (aVariable = 3) // Unit === void

  println(aWeirdValue)

  //side effects: println(), whiles, reassigning


  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "Hello" else "Goodbye"
  }

  val someValue = {
      2 < 3
  }

  val someOtherValue = {
      if(someValue) 239 else 986
      42
  }

   println(someOtherValue)

}
