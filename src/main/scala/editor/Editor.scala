package editor

object Editor {
  val d = new SecretMaramaLogic("example");

  def main(args: Array[String]): Unit = {
    println(Hello() + " Marama!")
  }

  def Hello() : String = {
    val Hello = "Hello"
    Hello
  }

  def doSecretMaramaLogic(): Unit = {
    d.doLogic();
  }
}