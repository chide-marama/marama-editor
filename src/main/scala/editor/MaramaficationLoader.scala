package editor

import jawn.ast.{JArray, JValue}
import maramafication.{Joint, JointModel, MaramaficationManager, MaramaficationModel}
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
    var jointModelList = List[JointModel]()
    var jointList = List[Joint]()

    for (jsonMaramafication: JValue <- jsonMaramafications.vs) {
      // Load the JSON in as JArray instances
      val jsonJointModels = jsonMaramafication.get("joint_models").asInstanceOf[JArray]
      jointModelList = getJointModelListFromJson(jsonJointModels)

      val jsonJoints = jsonMaramafication.get("joints").asInstanceOf[JArray]
      jointList = getJointListFromJson(jsonJoints)

      // Add the created maramafication to the list
      maramaficationList = maramaficationList.::(getMaramaficationModelFromJson(jsonMaramafication, jointModelList, jointList))
    }
    maramaficationList
  }

  def getMaramaficationModelFromJson(jsonMaramafication: JValue, jointModelList: List[JointModel], jointList: List[Joint]): MaramaficationModel ={
    MaramaficationModel(
      jsonMaramafication.get("name").asString,
      jsonMaramafication.get("obj_location").asString,
      jsonMaramafication.get("image_location").asString,
      jointModelList,
      jointList
    )
  }

  def getJointListFromJson(jsonJointList: JArray): List[Joint] ={
    var jointList = List[Joint]()

    for (jsonJoint <- jsonJointList.vs) {
      // Add the jsonJoint to the list
      jointList = jointList.::(Joint(
        jsonJoint.get("model_id").asInt,
        getVector3FromJson(jsonJoint.get("location_vector")),
        getVector3FromJson(jsonJoint.get("direction_vector"))
      ))
    }
    jointList
  }

  /**
    * Create a list of JointModels according to the given json (JArray) input.
    * @param jsonJointModelList
    */
  def getJointModelListFromJson(jsonJointModelList: JArray): List[JointModel] ={
    var jointModelList = List[JointModel]()
    for (jsonJoint <- jsonJointModelList.vs) {
      // Add the jsonJoint to the list
      jointModelList = jointModelList.::(JointModel(
        jsonJoint.get("id").asInt,
        jsonJoint.get("name").asString,
        jsonJoint.get("male").asString,
        jsonJoint.get("female").asString,
        jsonJoint.get("scale_factor").asInt
      ))
    }
    jointModelList
  }

  def getVector3FromJson(jsonVector: JValue): Vector3 = {
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
