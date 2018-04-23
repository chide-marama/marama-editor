import org.scalatest._
package example {

  class HelloTest extends FlatSpec {
    "Hello" should "return hello" in {
      assert(Hello.Hello() == "Hello")
    }
  }
}