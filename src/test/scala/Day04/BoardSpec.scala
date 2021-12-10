package Day04

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class BoardSpec  extends AnyFlatSpec with should.Matchers {

  "Board" should "detect a winning diagonal" in {
    val leftToRightDiagonalWin = Board(List(
      List(Cell(0, true), Cell(1, false), Cell(2, false)),
      List(Cell(3, false), Cell(4, true), Cell(5, false)),
      List(Cell(6, false), Cell(7, false), Cell(8, true))
    ))
    leftToRightDiagonalWin.hasWinningDiagonal should be(true)

    val rightToLeftDiagonalWin = Board(List(
      List(Cell(0, false), Cell(1, false), Cell(2, true)),
      List(Cell(3, false), Cell(4, true), Cell(5, false)),
      List(Cell(6, true), Cell(7, false), Cell(8, false))
    ))
    rightToLeftDiagonalWin.hasWinningDiagonal should be(true)
  }

  it should "detect winning row" in {
    val middleWin = Board(List(
      List(Cell(0, false), Cell(1, false), Cell(2, false)),
      List(Cell(3, true), Cell(4, true), Cell(5, true)),
      List(Cell(6, false), Cell(7, false), Cell(8, false))
    ))
    middleWin.hasWinningRow should be(true)
  }

  it should "detect winning column" in {
    val middleWin = Board(List(
      List(Cell(0, false), Cell(1, true), Cell(2, false)),
      List(Cell(3, false), Cell(4, true), Cell(5, false)),
      List(Cell(6, false), Cell(7, true), Cell(8, false))
    ))
    middleWin.hasWinningColumn should be(true)
  }

  it should "get the sum of unmarked numbers" in {
    val completelyUnmarkedBoard = Board(List(
      List(Cell(0, false), Cell(1, false)),
      List(Cell(2, false), Cell(3, false))
    ))
    completelyUnmarkedBoard.getUnmarkedSum should be(6)

    val partiallyMarkedBoard = Board(List(
      List(Cell(0, true), Cell(1, false)),
      List(Cell(2, false), Cell(3, true))
    ))
    partiallyMarkedBoard.getUnmarkedSum should be(3)
  }
}
