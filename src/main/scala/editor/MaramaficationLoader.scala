package editor

import maramafication.{JointModel, MaramaficationModel}

import scala.io.Source

class MaramaficationLoader {
  val filename = "/src/main/scala/maramafications/test.mar"

  def readFile(): (List[MaramaficationModel], List[JointModel]) ={
    var a = jawn.Parser.parseFromString[jawn.ast.JValue](loadFile()) -> jawn.ast.JValue
    a._1.
    null
  }

  def loadFile(): String ={
    var str : String = ""
    for(line <- Source.fromFile(System.getProperty("user.dir") + filename).getLines){
      println(line)
      str += line
    }
    str
  }
}
