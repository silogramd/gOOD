package edu.cs3500.spreadsheets.model;

/***
 * Interface for CellContents that are solely values.
 */
public interface CellValue extends CellContents {

  void combine(CellValue acc, Operation o);
}
