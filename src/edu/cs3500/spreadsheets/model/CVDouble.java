package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVDouble extends CellValue {

  final double contents;

  public CVDouble(double d) {
    this.contents = d;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(this);
  }

  @Override
  public void accept(CycleVisitor cv) {
    //do nothing! Cycles are only relevant for References and Formulas.
  }

  @Override
  public String toString() {
    return String.format("%f", this.contents);
  }

}
