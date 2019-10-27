package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;

/**
 *  Interface for the model of spreadsheets.
 */
public interface SpreadsheetModel<k> {

  /**
   * Gets the cell value at the given coordinate.
   *
   * @param coord the coordinates of the desired cell
   * @return String value of the requested cell
   */
  CellValue getCellAt(Coord coord);

  /**
   * Updates or adds a cell at the desired coordinates.
   *
   * @param coord spot to add or update the cell.
   * @param string new value of the cell.
   */
  void editCell(Coord coord, String string);

}
