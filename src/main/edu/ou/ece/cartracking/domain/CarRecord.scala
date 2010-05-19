package edu.ou.ece.cartracking.domain

import javax.persistence._
import java.util.ArrayList;

@Entity
class CarRecord() {
  @Id
  @GeneratedValue
  var id: Long = 0l

  @OneToMany {val cascade = Array(CascadeType.ALL), val targetEntity = classOf[BluetoothRecord], val fetch = FetchType.LAZY}
  var bluetoothRecords: java.util.List[BluetoothRecord] = new ArrayList[BluetoothRecord];

  @OneToMany {val cascade = Array(CascadeType.ALL), val targetEntity = classOf[LicensePlateRecord], val fetch = FetchType.LAZY}
  var licensePlateRecords: java.util.List[LicensePlateRecord] = new ArrayList[LicensePlateRecord];


  def addBluetoothRecords(records: List[BluetoothRecord]) {

    records.foreach(r => {
      r.carRecord = this
      this.bluetoothRecords.add(r)
    })

  }

  def addLicensePlateRecords(records: List[LicensePlateRecord]) {

    records.foreach(r => {
      r.carRecord = this
      this.licensePlateRecords.add(r)
    })

  }

  def getBluetoothRecords: java.util.List[BluetoothRecord] = bluetoothRecords

  def getLicensePlateRecords: java.util.List[LicensePlateRecord] = licensePlateRecords

}
  