package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public interface ICell {

  public CellValue getValue();

  public String getRawValue();

  public Coord getCoord();

  void checkCycles(ArrayList<Coord> visited) throws IllegalStateException;

  void accept(CycleVisitor cv);
}
