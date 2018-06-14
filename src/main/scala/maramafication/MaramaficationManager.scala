package maramafication

import maramafication.exceptions.{MaramaficationNotFoundException, MultipleMaramaficationsFoundException}

/**
  * The manager containing all currently loaded MaramaficationModels.
  */
class MaramaficationManager {
  var maramaficationModels: List[MaramaficationModel] = List[MaramaficationModel]()
  var names: List[(Int, String)] = List[(Int, String)]()

  /**
    * Add a single maramafications model to the maramaficationModels list.
    * Also add its name to the names list.
    */
  def addMaramaficationModel(maramaficationModel: MaramaficationModel): Unit = {
    names = (maramaficationModel._id: Int, maramaficationModel._name: String) :: names
    maramaficationModels = maramaficationModel :: maramaficationModels
  }

  /**
    * Add a list of maramaficationmodels to the already tracked list.
    */
  def addMaramaficationModels(maramaficationModels: List[MaramaficationModel]): Unit = {
    this.names = maramaficationModels.map(x => (x._id, x._name))
    this.maramaficationModels = maramaficationModels ::: this.maramaficationModels
  }

  /**
    * Removes all MaramaficationModels
    */
  def clear(): Unit = {
    maramaficationModels = List[MaramaficationModel]()
    names = List[(Int, String)]()
  }

  /**
    * Retrieve a MaramaficationModel by its ID in the list.
    */
  def getMaramaficationModel(index: Int): MaramaficationModel = {
    maramaficationModels(index)
  }

  /**
    * Retrieve a MaramaficationModel by its name.
    */
  def getMaramaficationModelByName(name: String): MaramaficationModel = {
    var maramafications = maramaficationModels.filter(_._name == name)

    if (maramafications.length < 1) {
      throw MaramaficationNotFoundException()
    }

    if (maramafications.length > 1) {
      throw MultipleMaramaficationsFoundException()
    }
    maramafications.head
  }
}

/**
  * Access the MaramaficationManager through the Singleton pattern.
  */
object MaramaficationManager {
  private val _instance = new MaramaficationManager()

  def getInstance(): MaramaficationManager = {
    _instance
  }
}