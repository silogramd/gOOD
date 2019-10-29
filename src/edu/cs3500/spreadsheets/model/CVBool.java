package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVBool extends CellValue {
  final boolean content;

  public CVBool(boolean b) {
    this.content = b;
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
    return String.valueOf(this.content);
  }

}
