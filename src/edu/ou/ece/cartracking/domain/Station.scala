package edu.ou.ece.cartracking.domain

import java.util.Date

class Station {
  var id: Long
  var location: String
  var name: String
  var equipmentInformation: EquipmentInformation
  var setupDate: Date
  var comment: String
}