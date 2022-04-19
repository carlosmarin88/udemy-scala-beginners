package lectures.part2oop

object Enums {

  object Permissions extends  Enumeration {
    val READ, WRITE, EXECUTE, NONE = Value

    //add fields/methods
    def openDocument(): Unit =
      if(this == READ) println("opening document...")
      else println("reading not allowed")

  }

  val somePermissions = Permissions.READ

  //constructor args
  /*object PermissionsWithBits(bits: Int){
    val READ
  }*/

  def main(args: Array[String]): Unit = {
    /*example the enum for scala 2 no complete*/
  }
}
