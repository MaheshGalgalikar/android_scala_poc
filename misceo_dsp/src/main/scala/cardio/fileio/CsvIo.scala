package cardio.fileio

import java.io.File

import cardio.fileio.dto.CardioRecord

import scala.io.Source
import scala.util.{Success, Try}


/**
  * Created by kuba on 04.03.16.
  */
object CsvIo {

  def fromCsv(path: String): Seq[CardioRecord] = {
    fromCsv[CardioRecord](path)(CardioRecord.parse)
  }

  def fromCsv[T](path: String)(implicit parse: String => T): Seq[T] = {
    val lines = {
      // check whether first line is legitimate record - it could be a header
      val rawLines = Source.fromFile(path).getLines().toSeq
      Try(parse(rawLines.head)) match {
        case Success(record) => rawLines
        case _ => rawLines.tail
      }
    }
    lines.map(parse)
  }

  def toCsv[T](path: String, contents: Seq[T])(implicit write: T => String): Unit = {
    def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
      val p = new java.io.PrintWriter(f)
      try { op(p) } finally { p.close() }
    }

    printToFile(new File(path)) { p =>
      contents.foreach(t => p.println(write(t)))
    }
  }
}
