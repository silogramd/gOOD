package edu.cs3500.spreadsheets.model;

public class AddCell extends FormulaCell {

  private BasicCell[] args;
  private Coord coord;

  public AddCell(Coord coord, BasicCell[] args) {
    super(coord, args);
  }


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

  @Override
  public String getCoord() {
    return String.valueOf(Coord.colIndexToName(coord.col) + coord.row);
  }
}
