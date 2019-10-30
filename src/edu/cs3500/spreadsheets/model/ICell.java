package edu.cs3500.spreadsheets.model;


public interface ICell {

  CellValue getValue();

  String getRawValue();

  Coord getCoord();
}
