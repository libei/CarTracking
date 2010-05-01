package edu.ou.ece.cartracking.service

import edu.ou.ece.cartracking.domain.BluetoothRecord
import xml.XML

object BluetoothXMLParser {
  def parse(rawXml: String): List[BluetoothRecord] = {
    if (rawXml.length == 0)
      return List();

    var xml = XML.load rawXml;

    //    for (record <- (xml \\ "record")) {
    //      record \ "unixTime").text
    //    }

  }

}