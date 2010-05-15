package edu.ou.ece.cartracking.domain

import javax.persistence._
import java.util.ArrayList;


@Entity
class CarRecord() {
  @Id
  @GeneratedValue
  var id: Long = 0l

  @OneToMany {val cascade = Array(CascadeType.ALL), val targetEntity = classOf[BluetoothRecord], val fetch = FetchType.LAZY}
  var records: java.util.List[BluetoothRecord] = new ArrayList[BluetoothRecord];

  def addBluetoothRecords(records: List[BluetoothRecord]) {

    records.foreach(r => {
      r.carRecord = this
      this.records.add(r)
    })

  }

  def getBluetoothRecords: java.util.List[BluetoothRecord] = records

}
  