import org.scalatest._
package maramafication {

  import maramafication.exceptions.{MaramaficationNotFoundException, MultipleMaramaficationsFoundException}
  import maramafication.joint.{JointLocation, JointShape, Orientation}
  import util.Vector3

  class MaramaficationManagerSpec extends FlatSpec {
    "The MaramaficationManager" should "be able to add a MaramaficationModel to the MaramaficationModel list." in {
      val maramaficationManager = MaramaficationManager.getInstance()

      // Create a JointShape
      val jointShape = JointShape("ResultObjectLocation", "ArgumentObjectLocation", 0.8)

      // Create a JointLocation list
      val orientation = Orientation(25, Vector3(3.0, 4.0, 5.0))
      val jointCenter = Vector3(3.0, 4.0, 5.0)
      val jointLocation = JointLocation(jointCenter, orientation)
      val jointLocations = List[JointLocation](jointLocation)

      // Create the maramafication
      val maramafication = MaramaficationModel("TestMaramafication", "ObjectLocation", "ImgLocation", jointShape, jointLocations)

      assert(maramaficationManager.maramaficationModels.length === 0)
      maramaficationManager.addMaramaficationModel(maramafication)
      assert(maramaficationManager.maramaficationModels.length === 1)

      // Clear the MaramaficationManager
      maramaficationManager.clear()
    }

    "The MaramaficationManager" should "be able to add multiple MaramaficationModel to the MaramaficationModel list." in {
      val maramaficationManager = MaramaficationManager.getInstance()

      // Create a JointShape
      val jointShape = JointShape("ResultObjectLocation", "ArgumentObjectLocation", 0.8)

      // Create a JointLocation list
      val orientation = Orientation(25, Vector3(3.0, 4.0, 5.0))
      val jointCenter = Vector3(3.0, 4.0, 5.0)
      val jointLocation = JointLocation(jointCenter, orientation)
      val jointLocations = List[JointLocation](jointLocation)

      // Create the maramafication list
      val maramafication = MaramaficationModel("TestMaramafication", "ObjectLocation", "ImgLocation", jointShape, jointLocations)
      val maramaficationTwo = MaramaficationModel("TestMaramaficationTwo", "ObjectLocationTwo", "ImgLocationTwo", jointShape, jointLocations)
      val maramaficationList = List[MaramaficationModel](maramafication, maramaficationTwo)

      assert(maramaficationManager.maramaficationModels.length === 0)
      maramaficationManager.addMaramaficationModels(maramaficationList)
      assert(maramaficationManager.maramaficationModels.length === 2)

      // Clear the MaramaficationManager
      maramaficationManager.clear()
    }

    "The MaramaficationManager" should "be able to add clear the MaramaficationModels from the list." in {
      val maramaficationManager = MaramaficationManager.getInstance()

      // Create a JointShape
      val jointShape = JointShape("ResultObjectLocation", "ArgumentObjectLocation", 0.8)

      // Create a JointLocation list
      val orientation = Orientation(25, Vector3(3.0, 4.0, 5.0))
      val jointCenter = Vector3(3.0, 4.0, 5.0)
      val jointLocation = JointLocation(jointCenter, orientation)
      val jointLocations = List[JointLocation](jointLocation)

      // Create the maramafication list
      val maramafication = MaramaficationModel("TestMaramafication", "ObjectLocation", "ImgLocation", jointShape, jointLocations)
      val maramaficationTwo = MaramaficationModel("TestMaramaficationTwo", "ObjectLocationTwo", "ImgLocationTwo", jointShape, jointLocations)
      val maramaficationList = List[MaramaficationModel](maramafication, maramaficationTwo)

      assert(maramaficationManager.maramaficationModels.length === 0)
      maramaficationManager.addMaramaficationModels(maramaficationList)
      assert(maramaficationManager.maramaficationModels.length === 2)
      maramaficationManager.clear()
      assert(maramaficationManager.maramaficationModels.length === 0)

      // Clear the MaramaficationManager (you never know..)
      maramaficationManager.clear()
    }

    "The MaramaficationManager" should "be able to retrieve a MaramaficationModel from the MaramaficationModel list by its index." in {
      val maramaficationManager = MaramaficationManager.getInstance()

      // Create a JointShape
      val jointShape = JointShape("ResultObjectLocation", "ArgumentObjectLocation", 0.8)

      // Create a JointLocation list
      val orientation = Orientation(25, Vector3(3.0, 4.0, 5.0))
      val jointCenter = Vector3(3.0, 4.0, 5.0)
      val jointLocation = JointLocation(jointCenter, orientation)
      val jointLocations = List[JointLocation](jointLocation)

      // Create the maramafication
      val maramafication = MaramaficationModel("TestMaramafication", "ObjectLocation", "ImgLocation", jointShape, jointLocations)
      val maramaficationTwo = MaramaficationModel("TestMaramaficationTwo", "ObjectLocationTwo", "ImgLocationTwo", jointShape, jointLocations)

      maramaficationManager.addMaramaficationModel(maramafication)
      maramaficationManager.addMaramaficationModel(maramaficationTwo)

      val retrievedMaramafication = maramaficationManager.getMaramaficationModel(maramafication._id)

      assert(retrievedMaramafication === maramafication)

      // Clear the MaramaficationManager
      maramaficationManager.clear()
    }

    "The MaramaficationManager" should "be able to retrieve a MaramaficationModel from the MaramaficationModel list by its name." in {
      val maramaficationManager = MaramaficationManager.getInstance()

      // Create a JointShape
      val jointShape = JointShape("ResultObjectLocation", "ArgumentObjectLocation", 0.8)

      // Create a JointLocation list
      val orientation = Orientation(25, Vector3(3.0, 4.0, 5.0))
      val jointCenter = Vector3(3.0, 4.0, 5.0)
      val jointLocation = JointLocation(jointCenter, orientation)
      val jointLocations = List[JointLocation](jointLocation)

      // Create the maramafication
      val maramafication = MaramaficationModel("TestMaramafication", "ObjectLocation", "ImgLocation", jointShape, jointLocations)

      maramaficationManager.addMaramaficationModel(maramafication)

      val retrievedMaramafication = maramaficationManager.getMaramaficationModelByName("TestMaramafication")

      assert(retrievedMaramafication === maramafication)

      // Clear the MaramaficationManager
      maramaficationManager.clear()
    }

    "The MaramaficationManager" should "be able to throw an error if a MaramaficationModel is not found." in {
      val maramaficationManager = MaramaficationManager.getInstance()

      // Create a JointShape
      val jointShape = JointShape("ResultObjectLocation", "ArgumentObjectLocation", 0.8)

      // Create a JointLocation list
      val orientation = Orientation(25, Vector3(3.0, 4.0, 5.0))
      val jointCenter = Vector3(3.0, 4.0, 5.0)
      val jointLocation = JointLocation(jointCenter, orientation)
      val jointLocations = List[JointLocation](jointLocation)

      // Retrieve not existing maramafication
      assertThrows[MaramaficationNotFoundException] {
        val retrievedMaramafication = maramaficationManager.getMaramaficationModelByName("TestMaramafication")
      }

      // Clear the MaramaficationManager
      maramaficationManager.clear()
    }

    "The MaramaficationManager" should "be able to throw an error if a multiple MaramaficationModels with the same name are found." in {
      val maramaficationManager = MaramaficationManager.getInstance()

      // Create a JointShape
      val jointShape = JointShape("ResultObjectLocation", "ArgumentObjectLocation", 0.8)

      // Create a JointLocation list
      val orientation = Orientation(25, Vector3(3.0, 4.0, 5.0))
      val jointCenter = Vector3(3.0, 4.0, 5.0)
      val jointLocation = JointLocation(jointCenter, orientation)
      val jointLocations = List[JointLocation](jointLocation)

      // Create the maramafication
      val maramafication = MaramaficationModel("TestMaramafication", "ObjectLocation", "ImgLocation", jointShape, jointLocations)

      maramaficationManager.addMaramaficationModel(maramafication)
      maramaficationManager.addMaramaficationModel(maramafication)

      // Retrieve not existing maramafication
      assertThrows[MultipleMaramaficationsFoundException] {
        val retrievedMaramafication = maramaficationManager.getMaramaficationModelByName("TestMaramafication")
      }

      // Clear the MaramaficationManager
      maramaficationManager.clear()
    }
  }

}
