package edu.ou.ece.cartracking.service

import edu.ou.ece.cartracking.domain.BluetoothRecord
import java.util.Date
import edu.ou.ece.cartracking.utils.HttpClientUtils
import java.lang.String

class BluetoothSensor(uri: String) {

  //uri: http://127.0.0.1/bluetoothsensor/getrecords
  //
  // paras:  ?start=xx&end=xx

  def getRecords(start: Date, end: Date): List[BluetoothRecord] = {

    val unixStart = start.getTime / 1000L
    val unixEnd = end.getTime / 1000L

    val requestUrl = uri + "?start=" + unixStart + "&end=" + unixEnd
    val xml = HttpClientUtils.get(requestUrl)
    return BluetoothXMLParser.parse(xml)
  }

}

