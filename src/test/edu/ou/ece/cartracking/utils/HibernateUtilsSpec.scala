package edu.ou.ece.cartracking.domain

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import edu.ou.ece.cartracking.utils.HibernateUtils

@RunWith(classOf[JUnitRunner])
class HibernateUtilsSpec extends FlatSpec with ShouldMatchers {
  it should "read the configuration file and init itself" in {
    val factory = HibernateUtils.getSessionFactory
    factory should not be (null)
  }
}