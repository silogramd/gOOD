package edu.cs3500.spreadsheets.model;

public class Reference implements Formula {

  Coord reference;
  BasicSpreadsheetModel model = new BasicSpreadsheetModel();

  @Override
  public CellValue getValue() {
    return model.coordMap.get(reference).getValue();
  }

  @Override
  public CellValue accept(FormulaVisitor fv) {
    return null;
  }
}
