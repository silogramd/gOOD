package edu.cs3500.spreadsheets.model;

/**
 * Interface for CellContents that are solely values.
 */
public abstract class CellValue implements Formula {

  public abstract <R> R accept(CellValueVisitor<R> visitor);

  @Override
  public CellValue getValue() {
    return this;
  }


}
