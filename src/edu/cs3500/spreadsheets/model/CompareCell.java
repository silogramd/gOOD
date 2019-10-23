package edu.cs3500.spreadsheets.model;

/**
 * Represents a cell that will map multiply all the cells it contains
 */
public class CompareCell extends FormulaCell {

  private BasicCell[] args;
  private Coord coord;

  /**
   * Default constructor.
   *
   * @param coord
   * @param args
   */
  public CompareCell(Coord coord, BasicCell[] args) {
    super(coord, args);

    if (args.length < 2){
      throw new IllegalArgumentException("CompareCell: not enough args");
    } else if (args.length > 2){
      throw new IllegalArgumentException("CompareCell: too many enough args");
    }
  }


  /**
   * Compares the first arg to the second arg, determines if arg1 < arg2.
   *
   * @return arg1 < arg2
   * @throws IllegalArgumentException if cannot convert a string val to a double
   */
  @Override
  public String getValue() {
    boolean bool;

      try {
        bool = Double.valueOf(args[0].getValue()) < Double.valueOf(args[1].getValue());
      } catch (NumberFormatException ex) {
        throw new IllegalArgumentException("CompareCell: could not convert value to double");
      }

    return String.valueOf(bool);
  }

  /**
   * Gets the raw string value of this cell.
   *
   * @return raw string value of this cell
   */
  @Override
  public String getRawValue() {
    String rawVal = "(<";

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