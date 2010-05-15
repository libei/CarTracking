package edu.ou.ece.cartracking.domain

import javax.persistence._

@Entity
class BluetoothRecord {
  @Id
  @GeneratedValue
  var id: Long = 0l

  @ManyToOne
  @JoinColumn {val name = "CarRecordId", val nullable = false}
  var carRecord: CarRecord = null

  var unixTime = 0l
  var macAddress = ""
  var deviceType = ""
  var unitSN = ""

}