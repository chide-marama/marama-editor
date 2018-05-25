import org.scalatest._
package editor {

  class EditorTest extends FlatSpec {
    "Hello" should "return hello" in {
      assert(Editor.Hello() == "Hello")
    }
  }
}