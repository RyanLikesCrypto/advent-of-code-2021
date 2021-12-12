package Day05

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*

import scala.io.Source

class HydrothermalVentureSpec extends AnyFlatSpec with should.Matchers {

  "partOne" should "pass the official example" in {
    val lineSegments: List[LineSegment] = Source.fromResource("Day05/example.txt").getLines.toList.map(parseInput)
    val result = HydrothermalVenture.partOne(lineSegments)
    result should be(5)
  }

  it should "pass the official input" in {
    val lineSegments: List[LineSegment] = Source.fromResource("Day05/input.txt").getLines.toList.map(parseInput)
    val result = HydrothermalVenture.partOne(lineSegments)
    result should be(4728)
  }

  def parseInput(line: String): LineSegment = {
    val linePoints = line.split(" -> ")
      .map(point => point.split(","))
      .map(coordinates => Point(coordinates(0).toInt, coordinates(1).toInt))
    LineSegment(linePoints(0), linePoints(1))
  }

}
