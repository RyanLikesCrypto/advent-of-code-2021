package Day05

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*

import scala.io.Source

class GridWithDiagonalsSpec extends AnyFlatSpec with should.Matchers {

  "GridWithDiagonals" should "draw left to right and right to left" in {
    val leftToRightLineSegment = LineSegment(Point(0, 0), Point(2, 0))
    val rightToLeftLineSegment = LineSegment(Point(3, 2), Point(1, 2))
    /*
      2 | . 1 1 1
      1 | . . . .
      0 | 1 1 1 .
      y ---------
        x 0 1 2 3
    */
    val expectedGrid = GridWithDiagonals(List(
      List(1, 1, 1, 0),
      List(0, 0, 0, 0),
      List(0, 1, 1, 1)
    ))
    expectedGrid.print
    val grid = GridWithDiagonals(Seq(leftToRightLineSegment, rightToLeftLineSegment))
    grid.print
    grid should be(expectedGrid)
  }

  it should "draw up and down" in {
    val upLineSegment = LineSegment(Point(0, 0), Point(0, 2))
    val downLineSegment = LineSegment(Point(2, 3), Point(2, 1))
    /*
      3 | . . 1
      2 | 1 . 1
      1 | 1 . 1
      0 | 1 . .
      y -------
        x 0 1 2
    */
    val expectedGrid = GridWithDiagonals(List(
      List(1, 0, 0),
      List(1, 0, 1),
      List(1, 0, 1),
      List(0, 0, 1)
    ))
    val grid = GridWithDiagonals(Seq(upLineSegment, downLineSegment))
    grid should be(expectedGrid)
  }

  it should "draw overlaps" in {
    val horizontalLine = LineSegment(Point(0, 1), Point(2, 1))
    val verticalLine = LineSegment(Point(1, 0), Point(1, 2))
    /*
      2 | . 1 .
      1 | 1 2 1
      0 | . 1 .
      y -------
        x 0 1 2
    */
    val expectedGrid = GridWithDiagonals(List(
      List(0, 1, 0),
      List(1, 2, 1),
      List(0, 1, 0)
    ))
    val grid = GridWithDiagonals(Seq(horizontalLine, verticalLine))
    grid should be(expectedGrid)
  }

  it should "count dangerous points" in {
    val horizontalLine = LineSegment(Point(0, 1), Point(1, 1))
    val verticalLine = LineSegment(Point(1, 0), Point(1, 2))
    /*
      2 | . 1 .
      1 | 1 2 1
      0 | . 1 .
      y -------
        x 0 1 2
    */
    val expectedGrid = GridWithDiagonals(List(
      List(0, 1, 0),
      List(1, 2, 1),
      List(0, 1, 0)
    ))
    val grid = GridWithDiagonals(Seq(horizontalLine, verticalLine))
    grid.getDangerousPointCount should be(1)
  }

  it should "draw diagonals" in {
    val diagonalLineA = LineSegment(Point(0, 0), Point(2, 2))
    val diagonalLineB = LineSegment(Point(0, 2), Point(2, 0))
    /*
      2 | 1 . 1
      1 | . 2 .
      0 | 1 . 1
      y -------
        x 0 1 2
    */
    val expectedGrid = GridWithDiagonals(List(
      List(1, 0, 1),
      List(0, 2, 0),
      List(1, 0, 1)
    ))
    val grid = GridWithDiagonals(Seq(diagonalLineA, diagonalLineB))
    grid.print
    grid should be(expectedGrid)
    grid.getDangerousPointCount should be(1)
  }

}
