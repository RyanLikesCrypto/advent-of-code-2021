package Day06

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*
import sun.util.resources.cldr.vai.LocaleNames_vai_Latn

import scala.io.Source

class LanternfishSchoolGrowthSpec extends AnyFlatSpec with should.Matchers {

  "partOne" should "pass a basic example" in {
    val fish = List(8,7,6,5,4,3,2,1,0).map(Lanternfish.apply)
    val days = 9
    /*
            appending               in-order                sorted
    day 00: 876543210               876543210               012345678
    ------------------------------------------------------------------------------
    day 01: 7654321068              7654321068              0123456678
    day 02: 65432106578             65432106857             01234556678
    day 03: 543210654678            543210685746            012344556678
    day 04: 4321065435678           4321068574635           0123344556678
    day 05: 32106543245678          32106857463524          01223344556678
    day 06: 210654321345678         210685746352413         011223344556678
    day 07: 1065432102345678        1068574635241302        0011223344556678
    day 08: 065432106123456788      068574635241302681      001122334455666788
    day 09: 65432106501234567788    68574635241302681570    00112233445556667788
    */
    val expectedSchoolSize = 20
    val result = LanternfishSchoolGrowth.partOne(fish, days)
    result should be(expectedSchoolSize)
  }

  it should "pass the official example" in {
    val fish: List[Lanternfish] = Source.fromResource("Day06/example.txt").getLines.toList
      .map(_.split(",").toList.map(_.toInt))
      .flatten.map(Lanternfish.apply)
    val result = LanternfishSchoolGrowth.partOne(fish, 18)
    result should be(26)

    val longResult = LanternfishSchoolGrowth.partOne(fish, 80)
    longResult should be(5934)
  }

  it should "pass the official input" in {
    val fish: List[Lanternfish] = Source.fromResource("Day06/input.txt").getLines.toList
      .map(_.split(",").toList.map(_.toInt))
      .flatten.map(Lanternfish.apply)
    val result = LanternfishSchoolGrowth.partOne(fish, 80)
    result should be(350605)
  }

}
