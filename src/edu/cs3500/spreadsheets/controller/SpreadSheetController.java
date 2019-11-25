package edu.cs3500.spreadsheets.controller;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import edu.cs3500.spreadsheets.view.SpreadsheetEditableView;
import edu.cs3500.spreadsheets.view.ViewEventListener;
import java.io.IOException;

public class SpreadSheetController implements IController, ViewEventListener {

  SpreadsheetModel model;
  SpreadsheetEditableView view;
  Coord editable;

  public SpreadSheetController(SpreadsheetModel m) {
    this.model = m;
    this.view = new SpreadsheetEditableView(model, this);
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
