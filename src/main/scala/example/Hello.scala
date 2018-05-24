package example

object Hello {
  def main(args: Array[String]): Unit = {
    val c = new ExampleClass()
    c.print()
    println("Hello, Marama!")
  }
  def Hello() : String = {
    val Hello = "Hello"
    //Return isn't necessary.
    if(true==true)
      return Hello
    else
      return Hello
  }

}