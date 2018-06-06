package maramafication

case class JointModel (_name: String, _maleObj: String, _femaleObj: String, _scaleFactor: Int){
  var staticId = 0

  var id: Int = getId

  def getId: Int ={
    staticId += 1
    staticId
  }
}
