package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.Set;

/***
 * Geneeral Interface for CellContents that are Formulas.
 */
public interface Formula {

  CellValue getValue();

  void flattenHelp(ArrayList<CellValue> acc);

}
