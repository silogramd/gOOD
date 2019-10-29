package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

/***
 * Interface for CellContents that are solely values.
 */
public abstract class CellValue implements Formula {

  public CellValue combine(CellValue acc, Operation o) {
    return o.apply(acc, this);
  }

  @Override
  public CellValue getValue() {
    return this;
  }

  @Override
  public void checkCycles(ArrayList<Coord> visited) {

  }

}
