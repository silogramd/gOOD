package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;

/**
 * Interface for view event listeners. Has methods for changing the highlighted coord,
 * getting the highlighted cell, and pushing edits to the model.
 *
 */
public interface ViewEventListener {

  /**
   * Sets the coordinates of the cell being edited.
   * @param coord the coordinate of the cell being edited.
   */
  void setEditableCoord(Coord coord);

  /**
   * Returns the currently editable cell.
   * @return the editable cell.
   */
  Cell getEditableCell();

  /**
   * Confirm and pushes the edits to the editable cell to the model.
   * @param val the new raw value for the cell.
   */
  void confirmEdits(String val);
}
