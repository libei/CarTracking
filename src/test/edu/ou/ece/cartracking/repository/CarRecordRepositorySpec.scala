package edu.ou.ece.cartracking.repository

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import edu.ou.ece.cartracking.CarRecord
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CarRecordRepositorySpec extends FlatSpec with ShouldMatchers {
  it should "save the object into db" in {
    val carRecord: CarRecord = new CarRecord;
    CarRecordRepository.save(carRecord);

    carRecord.id should equal(0l)
  }

}