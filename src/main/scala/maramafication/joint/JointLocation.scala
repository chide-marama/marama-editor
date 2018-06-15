package maramafication.joint

import util.Vector3

/**
  * The class representing a Joint
  *
  * @param _jointCenter The position of the joint center in relation to the maramafication center
  * @param _orientation The orientation the joint has to be drawn with, from the _jointCenter as starting point
  */
case class JointLocation(_jointCenter: Vector3, _orientation: Orientation) {
}
