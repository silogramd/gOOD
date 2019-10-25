package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class Reference implements Formula {

  ArrayList<Coord> reference;
  BasicSpreadsheetModel model = new BasicSpreadsheetModel();

  //TODO: Getting the value of all the cells referenced? Is that a different interface?
  @Override
  public CellValue getValue() {
    return model.coordMap.get(reference.get(0)).getValue();
  }

  @Override
  public CellValue accept(FormulaVisitor fv) {
    return null;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    for (Coord c: reference) {
      acc.add(model.coordMap.get(c).getValue());
    }
  }
}
