package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class Reference implements Formula {

  ArrayList<Coord> reference;
  BasicSpreadsheetModel model = new BasicSpreadsheetModel();

  public Reference(Coord first, Coord last) {
    this.reference = new ArrayList<>();

    int width = Math.abs(last.col - first.col);
    int height = Math.abs(last.row - first.row);
    int colStart = Math.min(last.col, first.col);
    int rowStart = Math.min(last.row, first.row);
    int colEnd = width + colStart;
    int rowEnd = height + rowStart;

    for (int i = colStart; i <= colEnd; i++) {
      for (int j = rowStart; j <= rowEnd; j++) {
        reference.add(new Coord(i, j));
      }
    }

    System.out.println(reference.toString());
  }

  public Reference(Coord c) {

    this.reference = new ArrayList<>();
    reference.add(c);
  }

  //TODO: Getting the value of all the cells referenced? Is that a different interface?
  @Override
  public CellValue getValue() {
    if (reference.size() == 1) {
      return model.coordMap.get(reference.get(0)).getValue();
    } else {
      return new CVError();
    }
  }

  @Override
  public CellValue accept(FormulaVisitor fv) {
    return null;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    for (Coord c: reference) {
      if (model.coordMap.containsKey(c)) {
        acc.add(model.getCellAt(c));
      }
    }
  }

  @Override
  public String toString() {
    return getValue().toString();
  }
}
