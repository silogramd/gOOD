package edu.cs3500.spreadsheets.model;

/**
 * Represents a cell that will map add all the cells it contains.
 */
public class AddCell extends FormulaCell {

  private BasicCell[] args;

  /**
   * Default constructor.
   *
   * @param coord
   * @param args
   */
  public AddCell(Coord coord, BasicCell[] args) {
    super(coord);
    this.args = args;
  }

  /**
   * Map adds and returns the value as a string.
   *
   * @return String value of add multiply
   * @throws IllegalArgumentException if cannot convert a string val to a double
   */
  @Override
  public String getValue() {
    double acc = 0;

    for (BasicCell cell : args) {
      try {
        acc += Double.valueOf(cell.getValue());
      } catch (NumberFormatException ex) {
        throw new IllegalArgumentException("AddCell: could not convert value to double");
      }
    }

    return String.valueOf(acc);
  }

  /**
   * Gets the raw string value of this cell.
   *
   * @return raw string value of this cell
   */
  @Override
  public String getRawValue() {
    String rawVal = "(Add";

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
