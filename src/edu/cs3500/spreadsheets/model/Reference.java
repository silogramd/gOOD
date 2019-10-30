package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class Reference implements Formula {

  private final ArrayList<Coord> reference;
  private final BasicSpreadsheetModel model = new BasicSpreadsheetModel();
  private final String position;

  public Reference(Coord first, Coord last, Coord position) {
    this.reference = new ArrayList<>();
    this.position = position.toString();

    int width = Math.abs(last.col - first.col);
    int height = Math.abs(last.row - first.row);
    int colStart = Math.min(last.col, first.col);
    int rowStart = Math.min(last.row, first.row);
    int colEnd = width + colStart;
    int rowEnd = height + rowStart;
    for (int i = colStart; i <= colEnd; i++) {
      for (int j = rowStart; j <= rowEnd; j++) {
        Coord coord = new Coord(i,j);
        if (noCycles(coord)) {
          reference.add(coord);
        } else {
          throw new IllegalArgumentException("there is a cycle");
        }
      }
    }

  }

  public Reference(Coord c, Coord position) {
    this.position = position.toString();
    if (noCycles(c)) {
      this.reference = new ArrayList<>();
      reference.add(c);
    } else {
      throw new IllegalArgumentException("there is a cycle");
    }
  }

  @Override
  public CellValue getValue() {
    if (reference.size() == 1) {
      return model.coordMap
          .getOrDefault(reference.get(0), new Cell(new Coord(1,1))).getValue();
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


  private boolean noCycles(Coord coord) {

    String otherRaw = model.coordMap.getOrDefault(coord, new Cell(coord)).getRawValue();
    if (otherRaw.length() > 1) {
      if ((otherRaw.charAt(0) == '=') && (otherRaw.contains(position))) {
        return false;
      }
    }
    return true;
  }


  @Override
  public String toString() {
    return getValue().toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof Reference)) {
      return false;
    }

    Reference o = (Reference)other;

    boolean refSame = true;
    if (reference.size() == o.reference.size()) {
      ArrayList<Coord> copy = new ArrayList<>();
      copy.addAll(o.reference);
      for (Coord c : reference) {
        if (copy.contains(c)) {
          copy.remove(c);
        } else {
          refSame = false;
        }
      }
    }

    return this.position.equals(o.position) && refSame;
  }

  @Override
  public int hashCode() {
    return reference.hashCode() * position.hashCode() * 31;
  }
}
