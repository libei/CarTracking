package ou.ece.cartracking.service

import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import edu.ou.ece.cartracking.service.LicensePlateDetector
import java.net.URI

@RunWith(classOf[JUnitRunner])
class LicensePlateDetectorSpec extends FlatSpec with ShouldMatchers {
  it should "list all files within the given data range" in {

    val uri = this.getClass.getClassLoader.getResource("J00107/f0514,2138316,1,13JL,71,242,0,NONE,0,0,8,1,180,36.jpg")
    uri should not equal (null)

    val detector = new LicensePlateDetector(uri)
    val actual = detector.get(null, null)

    actual.length should equal(2)

  }

}
