package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

/***
 * Geneeral Interface for CellContents that are Formulas.
 */
public interface Formula {

  CellValue getValue();

  void flattenHelp(ArrayList<CellValue> acc);
}
