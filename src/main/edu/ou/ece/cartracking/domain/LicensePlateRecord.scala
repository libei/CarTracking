package edu.ou.ece.cartracking.domain

import java.util.Date
import javax.persistence.{Transient, Entity, Id, GeneratedValue}

@Entity
class LicensePlateRecord {
  @Id
  @GeneratedValue
  var id: Long = 0l

  @Transient
  var date: Date = null;

  @Transient
  var accuracy: float = 0.0f

  @Transient
  var number: String = ""

  @Transient
  var filename: String = ""

}