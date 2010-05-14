package edu.ou.ece.cartracking.domain

import javax.persistence._
import collection.jcl.ArrayList;


@Entity
class CarRecord() {
  @Id
  @GeneratedValue
  var id: Long = 0l

  @Transient
  var records = new ArrayList[BluetoothRecord];

  def addBluetoothRecords(records: List[BluetoothRecord]) {
    this.records addAll (records)
  }

}
  