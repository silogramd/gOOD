package edu.cs3500.spreadsheets.provider.controller;

import edu.cs3500.spreadsheets.controller.SpreadSheetController;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.provider.model.ModelAdapter;
import edu.cs3500.spreadsheets.provider.view.VisualWorksheetView;
import edu.cs3500.spreadsheets.provider.view.WorksheetView;
import edu.cs3500.spreadsheets.view.ViewEventListener;
import java.io.IOException;

public class ControllerAdapter implements WorksheetController, FeaturesMain {

  ModelAdapter model;
  WorksheetView view;
  ViewEventListener vel;

  public ControllerAdapter(ModelAdapter model, SpreadSheetController controller) {
    this.model = model;
    this.vel = controller;
    this.view = new VisualWorksheetView(model);
    view.addFeatures(this);
  }

  @Override
  public void goRender() throws IOException {
    view.render();
  }

  @Override
  public void selectCell(Coord c) {
    this.vel.setEditableCoord(c);
    this.view.highlightCell(c);
  }

  /**
   * Removes the selected cell - a features should have this in scope
   */
  @Override
  public void removeCell() {
    this.vel.confirmEdits("");
    this.view.refresh();
  }


  @Override
  public void moveSelectedUp() {

  }

  @Override
  public void moveSelectedLeft() {

  }

  @Override
  public void moveSelectedRight() {

  }

  @Override
  public void moveSelectedDown() {

  }

  @Override
  public void save() {

  }

  @Override
  public void load() {

  }

  @Override
  public void putCell(String s) {
    this.vel.confirmEdits(s);
    this.view.refresh();
  }

  @Override
  public void discard() {
    this.vel.confirmEdits("");
    this.view.refresh();
  }
}
