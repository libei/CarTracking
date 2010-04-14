package edu.ou.ece.cartracking.domain

import java.util.Date

class Station {
  var id: Long = 0l
  var location: String = ""
  var name: String = ""
  var equipmentInformation: EquipmentInformation = null
  var setupDate: Date = null
  var comment: String = ""
}