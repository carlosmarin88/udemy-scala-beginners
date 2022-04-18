package exercises

abstract class MyList2[+A] {

  def head: A
  def tail: MyList2[A]
  def isEmpty: Boolean
  def add[B>:A](element: B): MyList2[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList2[B]
  def flatMap[B](transformer: MyTransformer[A, MyList2[B]]): MyList2[B]
  def filter(predicate: MyPredicate[A]): MyList2[A]

  def ++[B>:A](list: MyList2[B]): MyList2[B]
}

object Empty extends MyList2[Nothing]{
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList2[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B>:Nothing](element: B): MyList2[B] = new Cons(element, Empty)
  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList2[B] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList2[B]]): MyList2[B] = Empty
  override def filter(predicate: MyPredicate[Nothing]): MyList2[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList2[B]): MyList2[B] = list
}

class Cons[+A](h: A, t: MyList2[A]) extends MyList2[A]{
  override def head: A = h
  override def tail: MyList2[A] = t
  override def isEmpty: Boolean = false
  override def add[B>:A](element: B): MyList2[B] = new Cons(element, this)
  override def printElements: String =
      if(t.isEmpty) "" + h
    else h + " " + t.printElements

  override def filter(predicate: MyPredicate[A]): MyList2[A] =
    if(predicate.test(h))
      new Cons(h, t.filter(predicate))
    else
      t.filter(predicate)

  override def map[B](transformer: MyTransformer[A, B]): MyList2[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  override def flatMap[B](transformer: MyTransformer[A, MyList2[B]]): MyList2[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  override def ++[B >: A](list: MyList2[B]): MyList2[B] =
    new Cons(h, t ++ list)
}

trait MyPredicate[-T]{
  def test(elem: T): Boolean
}

trait MyTransformer[-A,B]{
  def transform(elem: A) : B
}

object ListTest extends App{
  /*
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)

  println(list.toString)

   */
  val listOfIntegers: MyList2[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList2[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings: MyList2[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfStrings.toString)
  println(listOfIntegers.toString)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }))
  //println(listOfIntegers.map((elem: Int)=> elem * 2).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  //println(listOfIntegers.filter((elem)=> elem % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList2[Int]] {
    override def transform(elem: Int): MyList2[Int] =
      new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)

}
