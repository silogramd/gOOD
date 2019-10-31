package edu.cs3500.spreadsheets.model;


public interface ICell {

  CellValue getValue();

  String getRawValue();

  Coord getCoord();

  void update(String contents);

  void addReferencedBy(Coord other);

  void removeReferencedBy(Coord other);

  void refresh();
}
