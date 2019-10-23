package edu.cs3500.spreadsheets.model;

public interface SpreadsheetModel<K> {

  public K getCellAt(Coord c);

}
