package edu.ou.ece.cartracking.service

import edu.ou.ece.cartracking.domain.LicensePlateRecord

object LicensePlateParser {
  def parse(string: String): LicensePlateRecord = {

    val record = new LicensePlateRecord
    record.number = "13JL"
    record.accuracy = "71"
    record
  }

}