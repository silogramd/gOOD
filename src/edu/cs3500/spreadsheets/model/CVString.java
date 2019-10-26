package edu.cs3500.spreadsheets.model;

public class CVString implements CellValue {

  String contents;

  public CVString(String s) {
    this.contents = s;
  }

  @Override
  public void combine(CellValue acc, Operation o) {

  }

  @Override
  public CellValue getValue() {
    return null;
  }
}
