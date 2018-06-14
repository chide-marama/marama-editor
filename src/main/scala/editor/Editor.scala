package editor

import maramafication.{MaramaficationLoader, MaramaficationManager}

object Editor {
  def main(args: Array[String]): Unit = {
    val loader = MaramaficationLoader("/src/main/scala/maramafication_data/test.mar")

    // Load a .mar file
    loader.readFile(MaramaficationManager.getInstance())

    // Get a maramafication by it's name (specified inside the .mar)
    var bool = MaramaficationManager.getInstance().getMaramaficationModelByName("bool")
  }
}