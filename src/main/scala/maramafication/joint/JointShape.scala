package maramafication.joint

/**
  * The class representing a JointShape.
  * A joint can be created according to this shape.
  *
  * @param _resultObj     The object location of the file defining the 3D result object
  * @param _argumentObj   The object location of the file defining the 3D argument object
  * @param _scalingFactor The value for a simple, linear transformation with respect to the origin
  */
case class JointShape(_resultObj: String, _argumentObj: String, _scalingFactor: Double) {
}
