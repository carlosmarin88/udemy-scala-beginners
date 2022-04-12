package exercises

import scala.collection.mutable

class A(n: Int){
  var value = n
}

class B(n: Int){
  val value = new A(n)
}

object VarVsVal {

  def main(args: Array[String]): Unit = {
    //val x = new B(5)
    //x = new B(6)
    //x.value = new A(6)
    //x.value.value = 6

   /* x = new B(0)
    f(x)
    if(x.value.value == 0)
      println("f didn't do anything to x")
    else
      println("f did something to x")*/
   println( "1 + 2 +  3 = " + toNum( mutable.Queue(1,2,3)))
  }

  def toNum(q : mutable.Queue[Int]) = {
    var num = 0
    while(!q.isEmpty){
      num*=10
      num+=q.dequeue
    }
    num
  }
}
