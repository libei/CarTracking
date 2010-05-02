package edu.ou.ece.cartracking.service

import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec


//<records>
//  <record>
//    <unixTime></unixTime>
//    <macAddress></macAddress>
//    <deviceType></deviceType>
//    <unitSN></unitSN>
//  </record>
//  <record>
//  ...
//  </record>
//</records>

@RunWith(classOf[JUnitRunner])
class BluetoothXMLParserSpec extends FlatSpec with ShouldMatchers {
  it should "parse the empty xml" in {

    val records = BluetoothXMLParser.parse("")
    records.length should equal(0)

  }

  it should "parse xml and get records" in {

    val records = BluetoothXMLParser.parse("""
<records>
  <record>
    <unixTime>123</unixTime>
    <macAddress>abc</macAddress>
    <deviceType>cde</deviceType>
    <unitSN>edf</unitSN>
  </record>
  <record>
    <unixTime>098</unixTime>
    <macAddress>fgh</macAddress>
    <deviceType>hij</deviceType>
    <unitSN>jkl</unitSN>
  </record>
</records>""")

    records.length should equal(2)

  }


}