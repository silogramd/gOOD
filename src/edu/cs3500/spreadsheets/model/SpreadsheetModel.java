package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.Map;

/**
 *  Interface for the model of spreadsheets.
 */
public interface SpreadsheetModel<k> {

  /**
   * Gets the cell value at the given coordinate.
   * @param coord the coordinates of the desired cell
   * @return The cell at the given coordinate.
   */
  ICell getCellAt(Coord coord);

  /**
   * <p>Gets the raw contents of the Cell at the given coordinate.</p>
   *
   * @param coord the coordinates of the desired cell
   * @return the raw String value of the requested cell.
   */
  String getRawCellAt(Coord coord);

  /**
   * Updates or adds a cell at the desired coordinates.
   * @param coord spot to add or update the cell.
   * @param string new value of the cell.
   */
  void editCell(Coord coord, String string);

  /**
   * Gets the map of coordinates and their associated Cells.
   * @return
   */
  Map<Coord, ICell> getAllCells();

}
