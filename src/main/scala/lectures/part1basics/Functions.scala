package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterLessFunction(): Int = 42

  println(aParameterLessFunction())
  println(aParameterLessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  //WHEN YOU NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("side effect")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /*
  * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old".
  * 2. Factorial function 1 * 2 * 3 * .. * n
  * 3. A fibonacci function
  *   f(1) = 1
  *   f(2) = 1
  *   f(n) = f(n - 1) + f(n - 2)
  * 4. Tests if a number is prime
  * */

  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old"
  }

  println(greeting("Carlos", 33))

  def factorize(number: Int): Int = {

    if (number < 0) return -1
    if (number == 0) return 1

    number * factorize(number - 1)
  }

  def fibonacci(num: Int): Int = {
    if (num < 2) num
    else
      fibonacci(num - 1) + fibonacci(num - 2)
  }

  def isPrimeNumber(number: Int): Boolean = {

    def isPrimeUntil(t: Int): Boolean = {
      if(t <=1) true
      else number % t != 0 && isPrimeUntil(t -1)
    }

    isPrimeUntil(number / 2)
  }

  println("Factorial 5 is " + factorize(5))

  println("Fibonacci 3 is " + fibonacci(3))

}
