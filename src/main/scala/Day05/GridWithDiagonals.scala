package Day05

case class GridWithDiagonals(grid: List[List[Int]]) {
  def draw(lines: List[LineSegment]): GridWithDiagonals =
    lines.foldLeft(this)((accGrid: GridWithDiagonals, line: LineSegment) => accGrid.draw(line))

  def draw(line: LineSegment): GridWithDiagonals = {
    val allPoints: List[Point] = getAllPoints(line)
    allPoints.foldLeft[GridWithDiagonals](this)((accGrid: GridWithDiagonals, point: Point) => {
      GridWithDiagonals(accGrid.grid.zipWithIndex.map((column: List[Int], y: Int) => {
        if (y == point.y) {
          column.zipWithIndex.map((lineOverlapCount: Int, x: Int) => {
            if (point.x == x) lineOverlapCount + 1
            else lineOverlapCount
          })
        } else {
          column
        }
      }))
    })
  }

  def getDangerousPointCount: Int = grid.map(_.count(value => value > 1)).sum

  def print: Unit = {
    grid.map(_.map(_.toString).reduce((a, b) => {
      (a, b) match {
        case ("0", "0") => ".."
        case ("0", _) => s".$b"
        case (_, "0") => s"$a."
        case _ => s"$a$b"
      }
    })).foreach(println)
    println
  }

  private def getAllPoints(line: LineSegment): List[Point] = {
    val horizontals = List.range(line.from.x, line.to.x + line.xStep, line.xStep)
    val verticals = List.range(line.from.y, line.to.y + line.yStep, line.yStep)
    (horizontals, verticals) match {
      case (hors, y :: Nil) => hors.map(x => Point(x, y))
      case (x :: Nil, verts) => verts.map(y => Point(x, y))
      case (hors, verts) => hors.zip(verts).map((x, y) => Point(x, y))
    }
  }
}

object GridWithDiagonals {
  /**
   * Sequence needed due to type erasure
   */
  def apply(lineSegments: Seq[LineSegment]): GridWithDiagonals = {
    val maxX = lineSegments.map[Int](lineSegment => {
      if (lineSegment.from.x > lineSegment.to.x) lineSegment.from.x
      else lineSegment.to.x
    }).max
    val maxY = lineSegments.map[Int](lineSegment => {
      if (lineSegment.from.y > lineSegment.to.y) lineSegment.from.y
      else lineSegment.to.y
    }).max
    val grid: List[List[Int]] = List.fill(maxY + 1)(List.fill(maxX + 1)(0))
    GridWithDiagonals(grid).draw(lineSegments.toList)
  }
}
