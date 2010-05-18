package edu.ou.ece.cartracking.service

import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class LicensePlateParserSpec extends FlatSpec with ShouldMatchers {
  it should "parse the file name" in {
    val record = LicensePlateParser.parse("f0514,2138316,1,13JL,71,242,0,NONE,0,0,8,1,180,36.jpg")
    record.number should equal("13JL")
    record.accuracy should equal("71")
  }

}