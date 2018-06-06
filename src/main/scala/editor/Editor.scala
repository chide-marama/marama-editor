package editor

object Editor {
  val d = new SecretMaramaLogic("example")

  def main(args: Array[String]): Unit = {
    val loader = new MaramaficationLoader()
    loader.readFile()
  }

  def Hello() : String = {
    val Hello = "Hello"
    Hello
  }

  def doSecretMaramaLogic(): Unit = {
    d.doLogic();
  }
}