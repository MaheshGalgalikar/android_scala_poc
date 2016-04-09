package cardio.fileio.dto

/**
  * Created by kuba on 04.03.16.
  */

case class CardioRecord(x: Double, y: Double)

object CardioRecord {

  def parse(from: String): CardioRecord = {
    val splitted = from.split(",")
    val (x, y) = (splitted(0).toDouble, splitted(1).toDouble)
    CardioRecord(x,y)
  }

}


