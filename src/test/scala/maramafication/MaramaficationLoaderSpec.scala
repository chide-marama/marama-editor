import org.scalatest._
package maramafication {

  class MaramaficationLoaderSpec extends FlatSpec {
    "A MaramaficationLoader" should "be able to load a file and transform the contents into a string" in {
      val maramaficationLoader = MaramaficationLoader("/src/test/scala/maramafication/testfile.dat")
      val readString = maramaficationLoader.loadFile()
      assert(readString === "This content should be very simple, so that the file can be read and the file reader can be tested.Test.Third line.")
    }

    "A maramaficationLoader" should "get the correct amount of items from the .mar file." in {
      val loader = MaramaficationLoader("/src/test/scala/maramafication/test.mar")
      val manager = MaramaficationManager.getInstance()
      loader.readFile(manager)
      assert(manager.maramaficationModels.size == 2)
    }

    "A maramaficationLoader" should "load the correct data out of the .mar file." in {
      val loader = MaramaficationLoader("/src/test/scala/maramafication/test.mar")
      val manager = MaramaficationManager.getInstance()
      loader.readFile(manager)

      assert(manager.getMaramaficationModel(1)._name == "bool")
      assert(manager.getMaramaficationModel(1)._name == "bool")
      assert(manager.getMaramaficationModel(0)._objLocation == "ObjLocation")
      assert(manager.getMaramaficationModel(0)._imgLocation == "ImageLocation")
    }
    "A maramaficationLoader" should "load the correct amount of joints out of the .mar file." in {
      val loader = MaramaficationLoader("/src/test/scala/maramafication/test.mar")
      val manager = MaramaficationManager.getInstance()
      loader.readFile(manager)

      assert(manager.getMaramaficationModel(1)._jointLocations.length == 2)
      assert(manager.getMaramaficationModel(0)._jointLocations.length == 3)
    }
    "A maramaficationLoader" should "load the correct joint data out of the .mar file." in {
      val loader = MaramaficationLoader("/src/test/scala/maramafication/test.mar")
      val manager = MaramaficationManager.getInstance()
      loader.readFile(manager)

      assert(manager.getMaramaficationModel(1)._jointLocations(1)._orientation._unitVector.X == 8)
      assert(manager.getMaramaficationModel(1)._jointLocations(1)._orientation._unitVector.Y == 1)
      assert(manager.getMaramaficationModel(1)._jointLocations(1)._orientation._unitVector.Z == 1)
    }
  }

}