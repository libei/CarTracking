package ou.ece.cartracking.service

import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import edu.ou.ece.cartracking.service.LicensePlateDetector
import java.net.URI
import java.text.SimpleDateFormat

@RunWith(classOf[JUnitRunner])
class LicensePlateDetectorSpec extends FlatSpec with ShouldMatchers {
  it should "list all files within the given data range" in {

    //    val uri = this.getClass.getClassLoader.getResource("J00107/f0514,2138316,1,13JL,71,242,0,NONE,0,0,8,1,180,36.jpg")
    val uri = this.getClass.getClassLoader.getResource("licenseplates")
    uri should not equal (null)

    var df = new SimpleDateFormat("MMdd,HHmmSSS");
    var start = df.parse("0514,2139367")
    var end = df.parse("0514,2140199")

    val detector = new LicensePlateDetector(uri)
    val actual = detector.get(start, end)

    actual.length should equal(6)

  }

}
