package edu.ou.ece.cartracking.domain

import javax.persistence._


@Entity
class CarRecord() {
  @Id
  @GeneratedValue
  var id: Long = 0l

  @Transient
  var records: List[BluetoothRecord] = null;

  def addBluetoothRecords(records: List[BluetoothRecord]) {

  }

}
  