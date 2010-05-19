package edu.ou.ece.cartracking.repository

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import edu.ou.ece.cartracking.domain.{LicensePlateRecord, BluetoothRecord, CarRecord}

@RunWith(classOf[JUnitRunner])
class CarRecordRepositorySpec extends FlatSpec with ShouldMatchers {
  it should "save the object into db" in {
    val carRecord: CarRecord = new CarRecord;

    val btRecord1 = new BluetoothRecord()
    btRecord1.deviceType = "iPod"
    btRecord1.macAddress = "AS:XX:XX:::"
    btRecord1.unitSN = "ABCD"
    btRecord1.unixTime = 1234567678l;

    val btRecord2 = new BluetoothRecord()
    btRecord2.deviceType = "iTouch"
    btRecord2.macAddress = "BS:XX:XX:::"
    btRecord2.unitSN = "EFGH"
    btRecord2.unixTime = 1038438483l;

    carRecord.addBluetoothRecords(List(btRecord1, btRecord2))

    val lpRecord1 = new LicensePlateRecord()
    lpRecord1.accuracy = "88"
    lpRecord1.filename = "asdasdasd"
    lpRecord1.number = "alsoas"

    carRecord.addLicensePlateRecords(List(lpRecord1))

    CarRecordRepository.save(carRecord);

    carRecord.id should not equal (0l)

    val loaded = CarRecordRepository.load(carRecord.id)
    loaded.getBluetoothRecords.size should equal(2)
    loaded.getLicensePlateRecords.size should equal(1)

  }


}