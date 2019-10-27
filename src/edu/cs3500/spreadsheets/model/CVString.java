package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVString extends CellValue {

  final String contents;

  public CVString(String s) {
    this.contents = s;
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

  @Override
  public String toString() {
    return this.contents;
  }
}
