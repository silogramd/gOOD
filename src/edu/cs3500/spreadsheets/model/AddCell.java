package edu.cs3500.spreadsheets.model;

public class AddCell extends FormulaCell<Double> {

  AddCell(Cell... args) {
    super(args);
  }

  @Override
  public Double apply() {
    try {
      double outpt = 0;
      for (Cell c: cells) {
        outpt += (double) c.evaluate();
      }
      return outpt;
    } catch (ClassCastException e) {
      throw new IllegalArgumentException("Cells do not all have numbers in them.");
    }
  }

}
