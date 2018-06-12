package editor

import maramafication.{MaramaficationLoader, MaramaficationManager}

object Editor {
  def main(args: Array[String]): Unit = {
    val loader = MaramaficationLoader("/src/main/scala/maramafication_data/test.mar")
    val manager = MaramaficationManager.getInstance()

    // Load a .mar file
    loader.readFile(manager)

    // Get a maramafication by it's name (specified inside the .mar)
    var bool = manager.getMaramaficationModelByName("bool")
  }
}