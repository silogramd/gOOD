package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVBool extends CellValue {
  final boolean content;

  public CVBool(boolean b) {
    this.content = b;
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
