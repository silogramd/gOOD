package edu.cs3500.spreadsheets.model;

/**
 * Represents a cell that will map concat all the cells it contains.
 */
public class ConcatCell extends FormulaCell {

  private BasicCell[] args;

  /**
   * Default constructor.
   *
   * @param coord
   * @param args
   */
  public ConcatCell(Coord coord, BasicCell[] args) {
    super(coord);
    this.args = args;
  }


  /**
   * Map multiplies and returns the value as a string.
   *
   * @return String value of map multiply
   * @throws IllegalArgumentException if cannot convert a string val to a double
   */
  @Override
  public String getValue() {
    String acc = "";

    for (BasicCell cell : args) {
      acc += cell.getValue();
    }

    return acc;
  }

  /**
   * Gets the raw string value of this cell.
   *
   * @return raw string value of this cell
   */
  @Override
  public String getRawValue() {
    String rawVal = "(CONCAT";

    for (BasicCell cell : args) {
      if (cell instanceof FormulaCell) {
        rawVal += " " + cell.getRawValue();
      } else {
        rawVal += " " + cell.getCoord();
      }
    }
    return rawVal + ")";
  }
}