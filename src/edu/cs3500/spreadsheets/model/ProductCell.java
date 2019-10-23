package edu.cs3500.spreadsheets.model;

/**
 * Represents a cell that will map multiply all the cells it contains.
 */
public class ProductCell extends FormulaCell {

  private BasicCell[] args;
  private Coord coord;

  /**
   * Default constructor.
   *
   * @param coord
   * @param args
   */
  public ProductCell(Coord coord, BasicCell[] args) {
    super(coord, args);
  }


  /**
   * Map multiplies and returns the value as a string.
   *
   * @return String value of map multiply
   * @throws IllegalArgumentException if cannot convert a string val to a double
   */
  @Override
  public String getValue() {
    double acc = 0;

    for (BasicCell cell : args) {
      try {
        acc = acc * Double.valueOf(cell.getValue());
      } catch (NumberFormatException ex) {
        throw new IllegalArgumentException("ProductCell: could not convert value to double");
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
    String rawVal = "(PRODUCT";

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