package edu.ou.ece.cartracking.repository

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import edu.ou.ece.cartracking.domain.{BluetoothRecord, CarRecord}

@RunWith(classOf[JUnitRunner])
class CarRecordRepositorySpec extends FlatSpec with ShouldMatchers {
  it should "save the object into db" in {
    val carRecord: CarRecord = new CarRecord;

    val record1 = new BluetoothRecord()
    record1.deviceType = "iPod"
    record1.macAddress = "AS:XX:XX:::"
    record1.unitSN = "ABCD"
    record1.unixTime = 1234567678l;

    val record2 = new BluetoothRecord()
    record2.deviceType = "iTouch"
    record2.macAddress = "BS:XX:XX:::"
    record2.unitSN = "EFGH"
    record2.unixTime = 1038438483l;

    val bluetoothRecords = List(record1, record2)
    carRecord.addBluetoothRecords(bluetoothRecords)

    CarRecordRepository.save(carRecord);

    carRecord.id should not equal (0l)

    val loaded = CarRecordRepository.load(carRecord.id)
    loaded.getBluetoothRecords.size should equal(2)

  }


}