package maramafication

class MaramaficationManager {
  var maramaficationModels: List[MaramaficationModel] = List[MaramaficationModel]()
  var jointModels: List[JointModel] = List[JointModel]()

  def addMaramaficationModel(maramaficationModel: MaramaficationModel): Unit ={
    maramaficationModels = maramaficationModel :: maramaficationModels
  }
  def addMaramaficationModels(maramaficationModels: List[MaramaficationModel]): Unit ={
    this.maramaficationModels = maramaficationModels ::: this.maramaficationModels
  }

  def addJointModel(jointModel: JointModel): Unit ={
    jointModels = jointModel :: jointModels
  }

  def addJointModels(jointModels: List[JointModel]): Unit ={
    this.jointModels = jointModels ::: this.jointModels
  }

  def getMaramaficationModel(index: Int): MaramaficationModel ={
    maramaficationModels(index)
  }

  def getJointModel(index: Int): JointModel ={
    jointModels(index)
  }
}

object MaramaficationManager{
  private val _instance = new MaramaficationManager()

  def getInstance(): MaramaficationManager = {
    _instance
  }
}