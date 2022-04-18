package exercises

abstract class MyList[T] {

  val list: List[T]
  /*
  *   head = first element of the list
  *   tail = remainder of the list
  *   isEmpty = is this list empty
  *   add(int) => new list with this element added
  *   toString => a string representation of the list
  * */

  def head(): Int

  def tail(): List[T]

  def isEmpty(): Boolean

  def add(element: T): List[T]

  def toString(): String

}

class ListInt extends MyList[Int]{

  override val list: List[Int] = Nil
  override def head(): Int = list.head
  override def tail(): List[Int] = list.tail
  override def isEmpty(): Boolean = list.isEmpty
  override def add(element: Int): List[Int] = element::list
  override def toString(): String = list.toString
}
