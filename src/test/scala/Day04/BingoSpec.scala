package Day04

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*

import scala.io.Source

class BingoSpec extends AnyFlatSpec with should.Matchers {

  "Bingo" should "determine a basic score" in {
    val calls = List(1, 5, 7)
    val boards = List(
      Board(List(List(0, 1), List(2, 3))),
      Board(List(List(4, 5), List(6, 7)))
    )
    val result = Bingo.partOne(calls, boards.map(Board.apply))
    result should be(70)
  }

  it should "pass the official example" in {
    val rawLines = Source.fromResource("Day04/example.txt").getLines.toList
    val (callNumbers, boards) = parseInput(rawLines)
    val result = Bingo.partOne(callNumbers, boards)
    result should be(4512)
  }

  it should "pass the official input" in {
    val rawLines = Source.fromResource("Day04/input.txt").getLines.toList
    val (callNumbers, boards) = parseInput(rawLines)
    val result = Bingo.partOne(callNumbers, boards)
    result should be(74320)
  }

  def parseInput(rawLines: List[String]): (List[Int], List[Board]) = {
    val callNumbers = rawLines(0).split(",").map(_.toInt).toList
    val rawBoards: List[List[List[Int]]] = rawLines.tail.tail
      .map(line => if (line == "") "end" else line + "\n")
      .reduce((a, b) => a + b)
      .split("end")
      .map(_.split("\n").map(_.split(" ").filterNot(_.equals("")).map(_.toInt).toList).toList)
      .toList
    val boards: List[Board] = rawBoards.map(Board.apply).map(Board.apply)
    (callNumbers, boards)
  }

}
