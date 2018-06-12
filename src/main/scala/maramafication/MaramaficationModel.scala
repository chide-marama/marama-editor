package maramafication

case class MaramaficationModel (var _name: String, var _objLocation: String, var _imgLocation: String, var _jointModels: List[JointModel], var _joints: List[Joint]){
  var staticId = 0

  var id: Int = getId

  def getId: Int ={
    staticId += 1
    staticId
  }
}