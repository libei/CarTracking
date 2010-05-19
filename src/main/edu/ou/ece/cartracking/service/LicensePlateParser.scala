package edu.ou.ece.cartracking.service

import edu.ou.ece.cartracking.domain.LicensePlateRecord
import java.text.SimpleDateFormat

object LicensePlateParser {
  def parse(string: String): LicensePlateRecord = {
    val firstComma: Int = string.indexOf(",")
    val secondComma: Int = string.indexOf(",", firstComma + 1)
    val thirdComma: Int = string.indexOf(",", secondComma + 1)
    val fourthComma: Int = string.indexOf(",", thirdComma + 1)
    val fifthComma: Int = string.indexOf(",", fourthComma + 1)

    val record = new LicensePlateRecord
    record.number = string.substring(thirdComma + 1, fourthComma)
    record.accuracy = string.substring(fourthComma + 1, fifthComma)

    var df = new SimpleDateFormat("MMdd,HHmmSSS");
    record.date = df.parse(string.substring(1, secondComma))

    record

  }

}