package edu.cs3500.spreadsheets.model;

public class CVDouble implements CellValue {

  double contents;

  public CVDouble(double d) {
    this.contents = d;
  }

  @Override
  public void combine(CellValue acc, Operation o) {

  }

  @Override
  public CellValue getValue() {
    return null;
  }
}
