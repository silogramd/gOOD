package edu.cs3500.spreadsheets.controller;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import edu.cs3500.spreadsheets.view.SpreadsheetEditableView;
import edu.cs3500.spreadsheets.view.SpreadsheetView;
import edu.cs3500.spreadsheets.view.ViewEventListener;
import java.io.IOException;

/**
 * Implementation of the controller interface that uses a model, editable view, and coords.
 * Includes additional methods specific to our implementation of coords and cells.
 */
public class SpreadSheetController implements IController, ViewEventListener {

  private SpreadsheetModel model;
  private SpreadsheetView view;
  private Coord editable;

  /**
   * Editable gui constructor. Sets model, editable view, and editable coord.
   *
   * @param m the model to be used.
   */
  public SpreadSheetController(SpreadsheetModel m) {
    this.model = m;
    this.view = new SpreadsheetEditableView(model, this);
    this.editable = new Coord(1,1);
  }

  /**
   * Test constructor. Sets model, any view, and editable coord.
   *
   * @param m the model to be used.
   * @param view the view to be used.
   */
  public SpreadSheetController(SpreadsheetModel m, SpreadsheetView view) {
    this.model = m;
    this.view = view;
    this.editable = new Coord(1,1);
  }

  @Override
  public void start() throws IOException {
    this.view.render();
  }

  @Override
  public void setEditableCoord(Coord coord) {
    this.editable = coord;
  }

  @Override
  public Cell getEditableCell() {
    return model.getCellAt(editable);
  }

  @Override
  public void confirmEdits(String val) {
    model.editCell(editable, val);
  }
}
