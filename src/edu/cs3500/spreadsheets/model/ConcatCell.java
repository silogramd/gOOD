package edu.cs3500.spreadsheets.model;

public class ConcatCell extends FormulaCell<String> {

  ConcatCell(Cell... args) {
    super(args);
  }

  @Override
  public String apply() {
    StringBuilder sb = new StringBuilder();
    for (Cell c: cells) {
      sb.append(String.valueOf(c.evaluate()));
    }
    return sb.toString();
  }
}
