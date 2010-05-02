package edu.ou.ece.cartracking.repository

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import edu.ou.ece.cartracking.domain.BluetoothRecord

@RunWith(classOf[JUnitRunner])
class BluetoothRecordRepositorySpec extends FlatSpec with ShouldMatchers {
  it should "save the object into db" in {
    val r = new BluetoothRecord;
    BluetoothRecordRepository.save(r);

    r.id should not equal (0l)
  }

  it should "load object form db" in {
    val saved = new BluetoothRecord;
    saved.deviceType = "iPod"
    saved.macAddress = "AS:XX:XX:::"
    saved.unitSN = "ABCD"
    saved.unixTime = 1234567678l;
    BluetoothRecordRepository.save(saved);

    val loaded = BluetoothRecordRepository.load(saved.id)

    loaded.id should equal(saved.id)
    loaded.deviceType should equal(saved.deviceType)
    loaded.macAddress should equal(saved.macAddress)
    loaded.unitSN should equal(saved.unitSN)
    loaded.unixTime should equal(saved.unixTime)
  }

}