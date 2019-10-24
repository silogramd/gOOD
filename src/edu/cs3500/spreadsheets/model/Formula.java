package edu.cs3500.spreadsheets.model;

/***
 * Geneeral Interface for CellContents that are Formulas.
 */
public interface Formula extends CellContents {

  public CellValue accept(FormulaVisitor fv);

}
