package edu.cs3500.spreadsheets.model;

/**
 * Represents a basic cell with a formula.
 */
public abstract class FormulaCell implements BasicCell {

  private BasicCell[] args;
  private Coord coord;

  /**
   * Default constructor.
   *
   * @param coord
   * @param args
   */
  FormulaCell(Coord coord, BasicCell[] args) {
    this.args = args;
    this.coord = coord;
  }

  /**
   * Gets the coordinates of this cell.
   *
   * @return string format of the coordinates of this cell
   */
  @Override
  public String getCoord() {
    return String.format(Coord.colIndexToName(coord.col) + coord.row);
  }
}
