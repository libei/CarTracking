package edu.ou.ece.cartracking.domain

import javax.persistence._


@Entity
class CarRecord() {
  @Id
  @GeneratedValue
  var id: Long = 0l

}
  