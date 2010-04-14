package edu.ou.ece.cartracking.repository

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import edu.ou.ece.cartracking.domain.CarRecord

@RunWith(classOf[JUnitRunner])
class CarRecordRepositorySpec extends FlatSpec with ShouldMatchers {
  it should "save the object into db" in {
    val carRecord: CarRecord = new CarRecord;
    CarRecordRepository.save(carRecord);

    carRecord.id should not equal (0l)
  }

  it should "load object form db" in {
    val saved = new CarRecord;
    CarRecordRepository.save(saved);

    val loaded: CarRecord = CarRecordRepository.load(saved.id)

    loaded.id should equal(saved.id)
  }

}