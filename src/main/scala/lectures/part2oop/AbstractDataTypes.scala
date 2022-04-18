package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  //traits
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded{
    override val creatureType: String = "croc"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit = println(s"I'm a $creatureType and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc eat dog

  //traits vs abstract classes
  // 1 - traits do not have constructor parameters - but at scala v3 yes
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"

}
