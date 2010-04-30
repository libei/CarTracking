package edu.ou.ece.cartracking.domain

import javax.persistence.{Id, GeneratedValue}

class BluetoothRecord {
  @Id
  @GeneratedValue
  var id: Long = 0l

  var unixTime = 0
  var macAddress = ""
  var deviceType = ""
  var unitSN = ""

}