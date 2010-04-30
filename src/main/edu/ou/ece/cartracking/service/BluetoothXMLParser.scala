package ou.ece.cartracking.service

import edu.ou.ece.cartracking.domain.BluetoothRecord

class BluetoothXMLParser {
  def parse(rawXml: String): List[BluetoothRecord] = {
    if (rawXml.length == 0)
      return null

    //    var xml = XML.load rawXml;

    return null

    //    for (condiment <- (xml \\ "condiment")) {
    //  if ((condiment \ "@expired").text == "true")
    //    println("the " + condiment.text + " has expired!")
    //}

  }

}