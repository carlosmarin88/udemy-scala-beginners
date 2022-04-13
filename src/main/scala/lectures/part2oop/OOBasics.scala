package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
}
//class parameters are NOT FIELDS
// constructor
class Person(name: String, val age: Int) {
  //body
  val x = 2

  println(1 + 3)

  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

  /*
    Novel and a Writer

    Writer: first name, surname, year
      - method: fullname

    Novel: name year of realese, author
      - authorAge
      - isWrittenBy(author)
      - copy (new year of release) = new instance of Novel
   */

  /*
    Counter class
      -receives an int value
      -method current count
      -method to increment/decrement => new Counter
      -overload inc/dec to receive an amount
   */
}

class Writer(var firstname: String,var surname: String,var year: Int) {

  def fullname(): String ={
    s"$firstname $surname"
  }


  def canEqual(other: Any): Boolean = other.isInstanceOf[Writer]

  override def equals(other: Any): Boolean = other match {
    case that: Writer =>
      (that canEqual this) &&
        firstname == that.firstname &&
        surname == that.surname &&
        year == that.year
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(firstname, surname, year)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

/**
 * @param name
 * @param yearRelease
 */
class Novel(var name: String, var yearRelease: Int,var author: Writer){

  def isWrittenBy(author: Writer) ={
    this.author.equals(author)
  }

  def authorAge()={
    yearRelease - author.year
  }

  def copy(newYearRelease: Int): Novel ={
    new Novel(this.name, newYearRelease, this.author)
  }

}

class Counter(i: Int){

  private var count = i;

  def currentCount(): Unit ={
    count
  }
  def increment(): Unit ={
    count+=1
  }

  def decrement(): Unit ={
    count-=1
  }

  def increment(value: Int){
    count+=value
  }

  def decrement(value: Int): Unit ={
    count-=value
  }
}
