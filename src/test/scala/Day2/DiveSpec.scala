package Day2

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*

import scala.io.Source

class DiveSpec extends AnyFlatSpec with should.Matchers {

  "dive" should "handle empty list" in {
    val inputs = List()
    val result = Dive.dive(inputs)
    result should be(0)
  }

  it should "have no multiplied value if no depth is added" in {
    val inputs = List(Vector(Direction.forward, 1))
    val result = Dive.dive(inputs)
    result should be(0)
  }

  it should "have no multiplied value if resulting instructions have net zero depth" in {
    val inputs = List(
      Vector(Direction.forward, 1),
      Vector(Direction.down, 1),
      Vector(Direction.up, 1)
    )
    val result = Dive.dive(inputs)
    result should be(0)
  }

  it should "have no multiplied value if resulting instructions have no horizontal movement" in {
    val inputs = List(Vector(Direction.down, 1))
    val result = Dive.dive(inputs)
    result should be(0)
  }

  it should "multiply two non net-zero directions together" in {
    val inputs = List(Vector(Direction.down, 1), Vector(Direction.forward, 1))
    val result = Dive.dive(inputs)
    result should be(1)
  }

  it should "pass the official example" in {
    val inputs = Source.fromResource("Day2/OfficialExample.txt").getLines.toList.map(parseVector)
    val result = Dive.dive(inputs)
    result should be(150)
  }

  it should "pass the official list" in {
    val inputs = Source.fromResource("Day2/OfficialInput.txt").getLines.toList.map(parseVector)
    val result = Dive.dive(inputs)
    result should be(2019945)
  }

  "diveWithAim" should "not change depth on forward movement if aim is zero" in {
    val inputs = List(Vector(Direction.forward, 5))
    val result = Dive.diveWithAim(inputs)
    result should be(0)
  }

  it should "only increase depth if aim is non-zero" in {
    val inputs = List(Vector(Direction.down, 5), Vector(Direction.forward, 5))
    val result = Dive.diveWithAim(inputs)
    result should be(125)
  }

  it should "pass the official example" in {
    val inputs = Source.fromResource("Day2/OfficialExample.txt").getLines.toList.map(parseVector)
    val result = Dive.diveWithAim(inputs)
    result should be(900)
  }

  it should "pass the official input" in {
    val inputs = Source.fromResource("Day2/OfficialInput.txt").getLines.toList.map(parseVector)
    val result = Dive.diveWithAim(inputs)
    result should be(1599311480)
  }

  def parseVector(rawString: String): Vector = {
    val split = rawString.split(" ")
    Vector(Direction.valueOf(split.head), split.tail.head.toInt)
  }

}
