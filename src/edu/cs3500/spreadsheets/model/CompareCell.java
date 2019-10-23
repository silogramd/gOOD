package edu.cs3500.spreadsheets.model;

public class CompareCell extends FormulaCell<Boolean> {

  CompareCell(Cell... args) {
    if (args.length != 2) {
      throw new IllegalArgumentException("Too many cells to compare.");
    }
    this.cells = args;
  }

  @Override
  public Boolean apply() {
    try {
      double cell1 = (double) cells[0].evaluate();
      double cell2 = (double) cells[1].evaluate();
      return cell1 > cell2;
    } catch (ClassCastException e) {
      throw new IllegalArgumentException("Not all values are numbers.");
    }
  }
}
