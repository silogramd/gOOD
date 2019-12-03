package edu.cs3500.spreadsheets.provider.controller;

import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.view.ViewEventListener;

public class FeaturesAdapter implements FeaturesMain {

  ViewEventListener viewEventListener;

  FeaturesAdapter(ViewEventListener controller) {
    this.viewEventListener = controller;
  }

  @Override
  public void selectCell(Coord c) {
    this.viewEventListener.setEditableCoord(c);
  }

  /**
   * Removes the selected cell - a features should have this in scope
   */
  @Override
  public void removeCell() {
    this.viewEventListener.confirmEdits("");
  }

  @Override
  public void moveSelectedUp() {
    // extra credit, not handled.
  }

  @Override
  public void moveSelectedLeft() {
    // extra credit, not handled.
  }

  @Override
  public void moveSelectedRight() {
    // extra credit, not handled.
  }

  @Override
  public void moveSelectedDown() {
    // extra credit, not handled.
  }

  @Override
  public void save() {
    // extra credit, not handled.
  }

  @Override
  public void load() {
    // extra credit, not handled.
  }

  @Override
  public void putCell(String s) {
    this.viewEventListener.confirmEdits(s);
  }

  @Override
  public void discard() {
    // not handled by our controller.
  }
}
