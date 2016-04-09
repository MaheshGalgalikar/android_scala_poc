package cardio.model




object EcgRecord {
  def fromString(from: String): EcgRecord = {
    val splitted = from.split(",")
    EcgRecord(splitted(0).toLong, splitted(1).toDouble)
  }
}

case class EcgRecord(num: Long, ecg: Double) extends CardioRecord

