package editor

import jawn.ast.{JArray, JValue}
import maramafication.{JointModel, MaramaficationManager, MaramaficationModel}

import scala.io.Source

class MaramaficationLoader {
  val filename = "/src/main/scala/maramafications/test.mar"

  def readFile(maramaficationManager: MaramaficationManager): Unit ={
    // The jawn way of reading a json file.
    val file = jawn.Parser.parseFromString[jawn.ast.JValue](loadFile()).get

    // Retrieve the maramafication models from the json, and cast it to a JArray so we can work with a known type
    val maramaficationModels = loadMaramafications(file.get("MaramaficationModels").asInstanceOf[JArray])

    // Load the maramafications of the file into the manager.
    maramaficationManager.addMaramaficationModels(maramaficationModels)
  }

  def loadMaramafications(jsonMaramafications: JArray): List[MaramaficationModel] ={
    val maramafications = List[MaramaficationModel]()

//    for(jsonMaramafication <- jsonMaramafications){
//      val joints = List[JointModel]()
//      val marams = jsonMaramafication.get("JointModels").asInstanceOf[JArray]
//        println("hoi")
//      for(jsonJoint<- marams.vs) {
//        println(jsonJoint)
//        joints = JointModel() :: joints
//        joints(jsonJoint.get)
//      }
//      val model = MaramaficationModel(
//        jsonMaramafication.get("name").asString,
//        jsonMaramafication.get("obj_location").asString,
//        jsonMaramafication.get("image_location").asString,
//
//      )
//      list = model :: list
//    }

    null
  }

  def loadJoint(jsonJoint: JArray): List[JointModel] ={

//    for(jsonJoints <- jsonJoints.vs){
////      println(jsonJoints)
//    }
    null
  }

  /**
    * Read a JSON file and return the string containing all JSON data.
    */
  def loadFile(): String ={
    var str : String = ""
    for(line <- Source.fromFile(System.getProperty("user.dir") + filename).getLines){
      str += line
    }
    str
  }
}
