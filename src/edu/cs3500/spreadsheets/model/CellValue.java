package edu.cs3500.spreadsheets.model;

/***
 * Interface for CellContents that are solely values.
 */
public abstract class CellValue implements Formula {

  public void combine(CellValue acc, Operation o) {
    acc = o.apply(acc, this);
  }

}
