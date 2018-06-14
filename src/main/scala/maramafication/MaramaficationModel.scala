package maramafication

import maramafication.joint.{JointLocation, JointShape}

/**
  * A model containing all data of a Maramafication, so that it can be defined and stored.
 *
  * @param _name The name of the maramafication
  * @param _objLocation The location of the shape of the maramafication
  * @param _imgLocation The image previewing the maramafication
  * @param _jointShape Shape of the joints
  * @param _jointLocations The location of the different joints
  */
case class MaramaficationModel (var _name: String, var _objLocation: String, var _imgLocation: String, var _jointShape: JointShape, var _jointLocations: List[JointLocation]){
  var _id : Int = MaramaficationModel.staticId
  MaramaficationModel.staticId += 1
}

object MaramaficationModel {
  var staticId = 0
}