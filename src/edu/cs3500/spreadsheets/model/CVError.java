package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVError extends CellValue {

  @Override
  public void combine(CellValue acc, Operation o) {
    acc = this;
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
