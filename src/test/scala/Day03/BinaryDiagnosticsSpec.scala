package Day03

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*

import scala.io.Source

class BinaryDiagnosticsSpec extends AnyFlatSpec with should.Matchers {

  "partOne" should "handle an empty list" in {
    val inputs = List()
    val result = BinaryDiagnostics.partOne(inputs)
    result should be(0)
  }

  it should "square a single list" in {
    val inputs = List(List(0,0,1,0,0))
    val result = BinaryDiagnostics.partOne(convert(inputs))
    result should be(16)
  }

  it should "square two of the same" in {
    val inputs = List(List(0,0,1,0,0), List(0,0,1,0,0))
    val result = BinaryDiagnostics.partOne(convert(inputs))
    result should be(16)
  }

  it should "pass the official example" in {
    val inputs = Source.fromResource("Day03/OfficialExample.txt").getLines.toList.map(parseBits)
    val result = BinaryDiagnostics.partOne(inputs)
    result should be(198)
  }

  it should "pass the official input" in {
    val inputs = Source.fromResource("Day03/OfficialInput.txt").getLines.toList.map(parseBits)
    val result = BinaryDiagnostics.partOne(inputs)
    result should be(4139586)
  }

  "partTwo" should "pass the offical example" in {
    val inputs = Source.fromResource("Day03/OfficialExample.txt").getLines.toList.map(parseBits)
    val result = BinaryDiagnostics.partTwo(inputs)
    result should be(230)
  }

  it should "pass the official input" in {
    val inputs = Source.fromResource("Day03/OfficialInput.txt").getLines.toList.map(parseBits)
    val result = BinaryDiagnostics.partTwo(inputs)
    result should be(1800151)
  }

  def convert(rawInputs: List[List[Int]]): List[List[Bit]] = rawInputs.map(_.map(_.toString).map(Bit.valueOf))
  def parseBits(rawBits: String): List[Bit] = rawBits.map(_.toString).map(Bit.valueOf).toList

}
