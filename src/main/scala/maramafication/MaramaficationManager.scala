package maramafication

import maramafication.exceptions.{MaramaficationNotFoundException, MultipleMaramaficationsFoundException}

class MaramaficationManager {
  var maramaficationModels: List[MaramaficationModel] = List[MaramaficationModel]()
  var names = List[String]()

  /**
    * @param maramaficationModel The maramaficationmodel that has to be added to the list.
    */
  def addMaramaficationModel(maramaficationModel: MaramaficationModel): Unit ={
    names = maramaficationModel._name :: names
    maramaficationModels = maramaficationModel :: maramaficationModels
  }
  def addMaramaficationModels(maramaficationModels: List[MaramaficationModel]): Unit ={
    this.names = maramaficationModels.map(_._name)
    this.maramaficationModels = maramaficationModels ::: this.maramaficationModels
  }

  def getMaramaficationModel(index: Int): MaramaficationModel ={
    maramaficationModels(index)
  }

  def getMaramaficationModelByName(name: String): MaramaficationModel ={
    var maramafications = maramaficationModels.filter(_._name == name)

    if(maramafications.length < 1){
      throw MaramaficationNotFoundException()
    }

    if(maramafications.length > 1){
      throw MultipleMaramaficationsFoundException()
    }
    maramafications.head
  }
}

object MaramaficationManager{
  private val _instance = new MaramaficationManager()

  def getInstance(): MaramaficationManager = {
    _instance
  }
}