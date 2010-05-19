package edu.ou.ece.cartracking.service

import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import java.util.{Calendar, GregorianCalendar}

@RunWith(classOf[JUnitRunner])
class LicensePlateParserSpec extends FlatSpec with ShouldMatchers {
  it should "only parse the file with f heading" in {
    var record = LicensePlateParser.parse("d0514,2138316,1,13JL,71,242,0,NONE,0,0,8,1,180,36.jpg")
    record should equal(None)

    record = LicensePlateParser.parse("e0514,2138316,1,13JL,71,242,0,NONE,0,0,8,1,180,36.jpg")
    record should equal(None)

    record = LicensePlateParser.parse("f0514,2138316,1,13JL,71,242,0,NONE,0,0,8,1,180,36.jpg")
    record should not equal (None)
  }

  it should "parse the file name" in {
    val record = LicensePlateParser.parse("f0514,2138316,1,13JL,71,242,0,NONE,0,0,8,1,180,36.jpg").get
    record.number should equal("13JL")
    record.accuracy should equal("71")

    val calendar = new GregorianCalendar
    calendar.setTime(record.date)
    val month: Int = calendar.get(Calendar.MONTH)
    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
    val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
    val minute: Int = calendar.get(Calendar.MINUTE)
    val millisecond: Int = calendar.get(Calendar.MILLISECOND)

    month should equal(4) //4 is actually 5th month
    day should equal(14)
    hour should equal(21)
    minute should equal(38)
    millisecond should equal(316)
  }

}