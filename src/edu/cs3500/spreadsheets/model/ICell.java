package edu.cs3500.spreadsheets.model;

public interface ICell {

  public CellValue getValue();

  public String getRawValue();

  public Coord getCoord();

}
