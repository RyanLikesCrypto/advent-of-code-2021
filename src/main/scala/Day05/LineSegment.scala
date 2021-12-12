package Day05

case class LineSegment(from: Point, to: Point) {
  def xStep: Int = if (from.x - to.x < 0) 1 else -1
  def yStep: Int = if (from.y - to.y < 0) 1 else -1
}
