package DayOne

import org.scalatest.*
import flatspec.*
import matchers.*

import scala.io.Source

class SonarSweepSpec extends AnyFlatSpec with should.Matchers {

  "countIncreases" should "acknowledge increases" in {
    val inputs = List(199, 200)
    val result = SonarSweep.countIncreases(inputs)
    result should be(1)
  }

  it should "ignore decreases" in {
    val inputs = List(200, 199)
    val result = SonarSweep.countIncreases(inputs)
    result should be(0)
  }

  it should "only acknowledge increments in a list of both increases and decreases" in {
    val inputs = List(199, 200, 175, 180)
    val result = SonarSweep.countIncreases(inputs)
    result should be(2)
  }

  it should "pass the official example" in {
    val inputs = Source.fromResource("DayOne/PartOne_OfficialExample.txt").getLines.toList.map(_.toInt)
    val result = SonarSweep.countIncreases(inputs)
    result should be(7)
  }

  it should "pass the official list" in {
    val inputs = Source.fromResource("DayOne/PartOne_OfficialInput.txt").getLines.toList.map(_.toInt)
    val result = SonarSweep.countIncreases(inputs)
    result should be(1167)
  }

  "countSumIncreases" should "acknowledge increases in rolling 3's sums" in {
    val inputs = List(199, 200, 208, 210)
    val result = SonarSweep.countSumIncreases(inputs)
    result should be(1)
  }

  it should "ignore decreases in rolling 3's sums" in {
    val inputs = List(199, 200, 208, 175)
    val result = SonarSweep.countSumIncreases(inputs)
    result should be(0)
  }

  it should "pass the official example" in {
    val inputs = Source.fromResource("DayOne/PartTwo_OfficialExample.txt").getLines.toList.map(_.toInt)
    val result = SonarSweep.countSumIncreases(inputs)
    result should be(5)
  }

  it should "pass the official list" in {
    val inputs = Source.fromResource("DayOne/PartTwo_OfficialInput.txt").getLines.toList.map(_.toInt)
    val result = SonarSweep.countSumIncreases(inputs)
    result should be(1130)
  }

}
