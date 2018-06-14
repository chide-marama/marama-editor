package maramafication

import maramafication.exceptions.{MaramaficationNotFoundException, MultipleMaramaficationsFoundException}

/**
  * The manager containing all currently loaded MaramaficationModels.
  */
class MaramaficationManager {
  var maramaficationModels: List[MaramaficationModel] = List[MaramaficationModel]()

  /**
    * Add a single maramafications model to the maramaficationModels list.
    * Also add its name to the names list.
    */
  def addMaramaficationModel(maramaficationModel: MaramaficationModel): Unit = {
    maramaficationModels = maramaficationModel :: maramaficationModels
  }

  /**
    * Add a list of maramaficationmodels to the already tracked list.
    */
  def addMaramaficationModels(maramaficationModels: List[MaramaficationModel]): Unit = {
    this.maramaficationModels = maramaficationModels ::: this.maramaficationModels
  }

  /**
    * Removes all MaramaficationModels
    */
  def clear(): Unit = {
    maramaficationModels = List[MaramaficationModel]()
  }

  /**
    * Retrieve a MaramaficationModel by its ID in the list.
    */
  def getMaramaficationModel(id: Int): MaramaficationModel = {
    var maramafications = maramaficationModels.filter(_._id == id)

    if (maramafications.length < 1) {
      throw MaramaficationNotFoundException()
    }

    maramafications.head
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