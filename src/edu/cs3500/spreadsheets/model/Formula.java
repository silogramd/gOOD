package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.Set;

/***
 * General Interface for CellContents that are Formulas.
 */
public interface Formula {

  /**
   * Returns the final Cell Value of a Formula.
   * @return the final Cell Value.
   */
  CellValue getValue();

  /**
   * Helper function for the {@link Function} flatten method.
   * @param acc the accumulated flatten list.
   */
  void flattenHelp(ArrayList<CellValue> acc);

}
