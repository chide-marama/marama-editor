package maramafication

case class MaramaficationModel (var _name: String, var _objLocation: String, var _imgLocation: String, var _joints: List[JointModel]){
  var staticId = 0

  var id: Int = getId

  def getId: Int ={
    staticId += 1
    staticId
  }
}