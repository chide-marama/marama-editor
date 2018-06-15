package maramafication.joint

import util.Vector3

/**
  * The class representing an Orientation. Is used by Joints inside a Maramafication.
  *
  * The parameters are chosen according to the Visupol specification.
  * https://drive.google.com/file/d/0BwvE2Xxofa7HUm5mTVZqRXhabGM/view?usp=sharing
  */
case class Orientation(_angle: Double, _unitVector: Vector3) {
}
