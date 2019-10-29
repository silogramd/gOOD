package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

/***
 * Geneeral Interface for CellContents that are Formulas.
 */
public interface Formula {

  public CellValue getValue();

  public void flattenHelp(ArrayList<CellValue> acc);

  void checkCycles(ArrayList<Coord> visited);

  void accept(CycleVisitor cv);
}
