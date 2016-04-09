package cardio.peak

import cardio.Consts
import cardio.model.EcgRecord
import cardio.fileio.CsvIo

/**
  * Created by ubu on 4/9/2016.
  */
object PeakDetectionAnalysis {

  def performAnalysis(freq: Double, fileName: String) = {
    val ecgRecords = CsvIo.fromCsv[EcgRecord](Consts.SimpleDataLoader.storageRoot + fileName)(EcgRecord.fromString)

  }

}
