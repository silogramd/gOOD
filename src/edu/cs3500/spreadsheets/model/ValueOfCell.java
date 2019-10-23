package edu.cs3500.spreadsheets.model;

import java.text.Normalizer.Form;

/**
 * Represents a cell that will copy the value of another cell.
 */
public class ValueOfCell extends FormulaCell {

  private BasicCell[] args;

  /**
   * Default constructor.
   *
   * @param coord
   * @param args
   */
  public ValueOfCell(Coord coord, BasicCell[] args) {
    super(coord);

    if (args.length == 1) {
      this.args = args;
    } else if (args.length < 1){
      throw new IllegalArgumentException("ValueOfCell: not enough args");
    } else {
      throw new IllegalArgumentException("ValueOfCell: too many enough args");
    }
  }


  /**
   * Returns the value of the selected other cell.
   *
   * @return the value of the other cell.
   */
  @Override
  public String getValue() {

    return args[0].getValue();
  }

  /**
   * Gets the raw string value of this cell.
   *
   * @return raw string value of this cell
   */
  @Override
  public String getRawValue() {
    return "= " + args[0].getValue();
  }
}