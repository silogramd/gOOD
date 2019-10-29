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
    ArrayList<Coord> visited = new ArrayList<>();
    for (int i = colStart; i <= colEnd; i++) {
      for (int j = rowStart; j <= rowEnd; j++) {
        Coord coord = new Coord(i,j);
        reference.add(coord);
      }
    }

    System.out.println(reference.toString());
  }

  public Reference(Coord c) {

    this.reference = new ArrayList<>();
    reference.add(c);
  }

  @Override
  public CellValue getValue() {
    if (reference.size() == 1) {
      return model.coordMap.get(reference.get(0)).getValue();
    } else {
      return new CVError();
    }
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    for (Coord c: this.reference) {
      if (model.coordMap.containsKey(c)) {
        acc.add(model.getCellAt(c).getValue());
      }
    }
  }

  @Override
  public void checkCycles(ArrayList<Coord> visited) {
    for (Coord c: this.reference) {
      if (visited.contains(c)) {
        throw new IllegalStateException("Cycle in Cells Found.");
      } else {
        model.getCellAt(c).checkCycles(visited);
      }
    }
  }

  @Override
  public String toString() {
    return getValue().toString();
  }
}
