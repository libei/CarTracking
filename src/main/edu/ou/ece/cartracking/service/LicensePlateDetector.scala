package edu.ou.ece.cartracking.service

import java.util.Date
import edu.ou.ece.cartracking.domain.LicensePlateRecord
import java.net.{URL}
import java.io.File
import collection.mutable.ListBuffer

class LicensePlateDetector(url: URL) {
  def get(start: Date, end: Date): List[LicensePlateRecord] = {

    val files = new ListBuffer[File]
    val root = new File(url.getPath)
    val subFolders = root.listFiles
    subFolders.foreach(fd => {
      files.appendAll(fd.listFiles)
    })

    val records = new ListBuffer[LicensePlateRecord]
    files.foreach(f => {
      val record: Option[LicensePlateRecord] = LicensePlateParser.parse(f.getName)
      if (!record.equals(None)) {
        val r = record.get
        if (r.date.compareTo(end) < 0 && r.date.compareTo(start) > 0)
          records += r
      }
    })

    records.toList

  }

}