package edu.ou.ece.cartracking.service

import java.util.Date
import edu.ou.ece.cartracking.domain.LicensePlateRecord
import java.net.{URL}

class LicensePlateDetector(url: URL) {
  def get(start: Date, end: Date): List[LicensePlateRecord] = {
    return List()
  }

}