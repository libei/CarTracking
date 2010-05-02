package edu.ou.ece.cartracking.utils

import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec

@RunWith(classOf[JUnitRunner])
class HttpClientUtilsSpec extends FlatSpec with ShouldMatchers {
  it should "return null if the url is incorrect" in {
    val res = HttpClientUtils.get("www.doesnotexists.mars")

    res should equal(null)

  }

  it should "return content for a valid url" in {
    val res = HttpClientUtils.get("http://www.google.com")

    res.contains("Google Search") should equal(true)


  }

}
