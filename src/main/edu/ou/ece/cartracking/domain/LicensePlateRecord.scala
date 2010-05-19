package edu.ou.ece.cartracking.domain

import java.util.Date
import javax.persistence._

@Entity
class LicensePlateRecord {
  @Id
  @GeneratedValue
  var id: Long = 0l

  @Temporal {val value = TemporalType.TIME}
  @Column {val name = "_date"}
  var date: Date = null;

  @ManyToOne
  @JoinColumn {val name = "CarRecordId", val nullable = false}
  var carRecord: CarRecord = null

  var accuracy: String = ""

  var number: String = ""

  var filename: String = ""

}