package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

/***
 * Geneeral Interface for CellContents that are Formulas.
 */
public interface Formula extends CellContents {

  public CellValue getValue();

  public CellValue accept(FormulaVisitor fv);

  public void flattenHelp(ArrayList<CellValue> acc);

  void checkCycles(ArrayList<Coord> visited);
}
