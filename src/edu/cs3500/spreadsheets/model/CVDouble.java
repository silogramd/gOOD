package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVDouble extends CellValue {

  double contents;

  public CVDouble(double d) {
    this.contents = d;
  }

  @Override
  public CellValue getValue() {
    return this;
  }

  @Override
  public CellValue accept(FormulaVisitor fv) {
    return null;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(this);
  }
}
