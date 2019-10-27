package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVBlank extends CellValue {

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
    System.out.println("inside flatten help from blank cell val");
    // doesnt do anything because we dont want this in the list of things to operate on
  }

  @Override
  public String toString() {
    return "";
  }
}
