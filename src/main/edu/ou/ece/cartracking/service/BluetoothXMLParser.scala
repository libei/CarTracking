package edu.ou.ece.cartracking.service

import edu.ou.ece.cartracking.domain.BluetoothRecord
import xml.XML
import collection.mutable.ListBuffer

object BluetoothXMLParser {
  def parse(rawXml: String): List[BluetoothRecord] = {
    if (rawXml.length == 0)
      return List();

    var xml = XML loadString rawXml;

    var records = new ListBuffer[BluetoothRecord]

    for (record <- (xml \\ "record")) {
      var r = new BluetoothRecord
      r.unixTime = (record \ "unixTime").text.toInt
      r.macAddress = (record \ "macAddress").text
      r.deviceType = (record \ "deviceType").text
      r.unitSN = (record \ "unitSN").text
      records += r
    }

    records.toList

  }

}