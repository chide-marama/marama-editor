package maramafication

import jawn.ast.{JArray, JValue}
import maramafication.joint.{JointLocation, JointShape, Orientation}
import util.Vector3

import scala.io.Source

class MaramaficationLoader {
  val filename = "/src/main/scala/maramafications/test.mar"

  def readFile(maramaficationManager: MaramaficationManager): Unit = {
    // The jawn way of reading a json file.
    val file = jawn.Parser.parseFromString[jawn.ast.JValue](loadFile()).get

    // Retrieve the maramafication models from the json, and cast it to a JArray so we can work with a known type
    val maramaficationModels = loadMaramafications(file.get("MaramaficationModels").asInstanceOf[JArray])

    // Load the maramafications of the file into the manager.
    maramaficationManager.addMaramaficationModels(maramaficationModels)
  }

  def loadMaramafications(jsonMaramafications: JArray): List[MaramaficationModel] = {
    // Create lists to store the JSON data
    var maramaficationList = List[MaramaficationModel]()

    for (jsonMaramafication: JValue <- jsonMaramafications.vs) {
      // Load the JSON in as JArray, containing JointShape data.
      val jsonJointShape = jsonMaramafication.get("JointShape")
      // Load these JointShapes in as a list.
      val jointShape = createJointShapeFromJson(jsonJointShape)

      // Load the JSON in as JArray, containing Joint data.
      val jsonJoints = jsonMaramafication.get("JointLocations").asInstanceOf[JArray]
      //  Load these Joints in as a list.
      val jointList = createJointLocationListFromJson(jsonJoints)

      // Add the created maramafication to the list
      maramaficationList = maramaficationList.::(createMaramaficationModelFromJson(jsonMaramafication, jointShape, jointList))
    }
    maramaficationList
  }

  /**
    * Extract the JValue and create a MaramaficationModel accordingly.
    */
  def createMaramaficationModelFromJson(jsonMaramafication: JValue, jointShape: JointShape, jointList: List[JointLocation]): MaramaficationModel ={
    MaramaficationModel(
      jsonMaramafication.get("Name").asString,
      jsonMaramafication.get("ObjLocation").asString,
      jsonMaramafication.get("ImageLocation").asString,
      jointShape,
      jointList
    )
  }

  /**
    * Extract the JArray, containing JointLocations, and create a list of JointLocations accordingly.
    */
  def createJointLocationListFromJson(jsonJointLocationList: JArray): List[JointLocation] ={
    var jointLocationList = List[JointLocation]()

    // Loop through the JArray and create a JointLocation for each item.
    // Add them to the jointLocationList.
    for (jsonJointLocation <- jsonJointLocationList.vs) {
      jointLocationList = jointLocationList.::(JointLocation(
        createVector3FromJson(jsonJointLocation.get("JointCenter")),
        Orientation(
          jsonJointLocation.get("Orientation").get("Angle").asDouble,
          createVector3FromJson(jsonJointLocation.get("Orientation").get("UnitVector"))
        )
      ))
    }
    jointLocationList
  }

  /**
    * Extract the JValue, containing a JointShape, and create the JointShape accordingly.
    */
  def createJointShapeFromJson(jsonJointShape: JValue): JointShape ={
    JointShape(
      jsonJointShape.get("Result").asString,
      jsonJointShape.get("Argument").asString,
      jsonJointShape.get("ScalingFactor").asDouble
    )
  }

  /**
    * Extract the JValue and create a Vector3 accordingly.
    */
  def createVector3FromJson(jsonVector: JValue): Vector3 = {
    Vector3(
      jsonVector.get("X").asDouble,
      jsonVector.get("Y").asDouble,
      jsonVector.get("Z").asDouble
    )
  }

  /**
    * Read a JSON file and return the string containing all JSON data.
    */
  def loadFile(): String = {
    var str: String = ""
    for (line <- Source.fromFile(System.getProperty("user.dir") + filename).getLines) {
      str += line
    }
    str
  }
}
