package edu.ou.ece.cartracking.domain

import javax.persistence.{Entity, Id, GeneratedValue}

@Entity
class BluetoothRecord {
  @Id
  @GeneratedValue
  var id: Long = 0l

  var unixTime = 0l
  var macAddress = ""
  var deviceType = ""
  var unitSN = ""

}