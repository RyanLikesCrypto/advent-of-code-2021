package Day04

case class Board(grid: List[Row]) {
  def hasWon: Boolean = hasWinningRow || hasWinningColumn

  def hasWinningDiagonal: Boolean = {
    val relevantLeftToRightCells: List[Cell] = grid.zipWithIndex.map[Cell]((row: Row, index: Int) => row(index))
    val relevantRightToLeftCells: List[Cell] = grid.reverse.zipWithIndex.map[Cell]((row: Row, index: Int) => row(index))
    val hasWinningLeftToRight: Boolean = relevantLeftToRightCells.foldLeft[Boolean](true)(allCellsHaveBeenCalled)
    val hasWinningRightToLeft: Boolean = relevantRightToLeftCells.foldLeft[Boolean](true)(allCellsHaveBeenCalled)
    hasWinningLeftToRight || hasWinningRightToLeft
  }

  def hasWinningRow: Boolean = grid.exists(row => row.foldLeft[Boolean](true)(allCellsHaveBeenCalled))

  def hasWinningColumn: Boolean = {
    val initialColumns: Grid = if (grid.isEmpty) List() else grid.head.map(_ => List())
    val columns: Grid = grid.foldLeft[Grid](initialColumns)((accumulatedColumns: Grid, row: Row) => {
      accumulatedColumns.zip(row).map((column: List[Cell], cell: Cell) => column :+ cell)
    })
    columns.exists(column => column.foldLeft[Boolean](true)(allCellsHaveBeenCalled))
  }

  def getUnmarkedSum: Int = grid.flatMap(_.filterNot(_.marked)).map(_.number).sum

  def markIfPresent(number: Int): Board = Board.apply(grid.map(_.map(cell => {
    if (cell.number == number) cell.copy(marked = true)
    else cell
  })))

  private def allCellsHaveBeenCalled = (acc: Boolean, cell: Cell) => acc && cell.marked
}

object Board {
  def apply(grid: List[List[Int]]) = grid.map(_.map(number => Cell(number, false)))
}
