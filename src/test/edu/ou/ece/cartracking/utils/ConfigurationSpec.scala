package edu.ou.ece.cartracking.utils

import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ConfigurationSpec extends FlatSpec with ShouldMatchers {
  it should "return properties" in {
    Configuration.bluetoothUrl should equal("http://127.0.0.1:8080/bluetoothsensor/getrecords")
  }

}