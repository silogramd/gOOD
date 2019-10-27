package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class FormulaValue implements Formula {

  CellValue contents;

  public FormulaValue(CellValue content) {
    this.contents = content;
  }

  @Override
  public CellValue accept(FormulaVisitor fv) {
    return null;
  }

  public ArrayList<CellValue> flatten() {
    return null;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(contents);
  }

  @Override
  public CellValue getValue() {
    return null;
  }
}
