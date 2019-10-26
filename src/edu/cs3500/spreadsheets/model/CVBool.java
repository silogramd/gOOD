package edu.cs3500.spreadsheets.model;

public class CVBool implements CellValue {
  boolean content;

  public CVBool(boolean b) {
    this.content = b;
  }

  @Override
  public CellValue getValue() {
    return this;
  }

  @Override
  public void combine(CellValue acc, Operation o) {

  }
}
