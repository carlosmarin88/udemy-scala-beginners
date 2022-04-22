package exercises

object Test extends App {


  val fileJson = "presentation/incoming/onlyIVA_VENTASConfig.json"
  val delta = "presentation/incoming/presentationConfig"

  val reg_ex = """.*\.(\w+)""".r

  fileJson match {
    case reg_ex(ext) =>println(s"$ext is extension")
    case _ => println("file_reg_ex none"); ""
  }

  delta match {
    case reg_ex(ext) =>println(s"$ext is extension")
    case _ => println("file_reg_ex none"); ""
  }
}
