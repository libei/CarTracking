package edu.ou.ece.cartracking

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CarSpec extends FlatSpec with ShouldMatchers {
  "A Stack" should "pop values in last-in-first-out order" in {
    3 should equal(3)
  }

}