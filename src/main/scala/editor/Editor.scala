package editor

import maramafication.MaramaficationManager

object Editor {
  val d = new SecretMaramaLogic("example")

  def main(args: Array[String]): Unit = {
    val loader = new MaramaficationLoader()
    val manager = MaramaficationManager.getInstance()
    loader.readFile(manager)
    var maram = manager.getMaramaficationModelByName("bool")
    println(maram._imgLocation)

  }

  def Hello() : String = {
    val Hello = "Hello"
    Hello
  }

  def doSecretMaramaLogic(): Unit = {
    d.doLogic();
  }
}