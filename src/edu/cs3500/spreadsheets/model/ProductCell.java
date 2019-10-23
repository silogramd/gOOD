package edu.cs3500.spreadsheets.model;

public class ProductCell extends FormulaCell<Double> {

  ProductCell(Cell... args) {
    super(args);
  }

  @Override
  public Double apply() {
    try {
      double outpt = 0;
      for (Cell c: cells) {
        outpt = outpt * (double) c.evaluate();
      }
      return outpt;
    } catch (ClassCastException e) {
      throw new IllegalArgumentException("Cells do not all have numbers in them.");
    }
  }
}
