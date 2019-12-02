package edu.cs3500.spreadsheets.provider.view;
//
//import java.awt.event.ActionListener;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseListener;
//import java.io.File;
import java.io.IOException;

//import edu.cs3500.spreadsheets.controller.Features;
import edu.cs3500.spreadsheets.controller.FeaturesMain;
//import edu.cs3500.spreadsheets.controller.KeyboardListener;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ViewWorksheet;

/**
 * Interface for the visual worksheets with methods needed to create, update, and interact with the
 * view.
 */
public interface WorksheetView {
  /**
   * Opens the visual view so it is visual to the user.
   */
  void render() throws IOException;

  /**
   * Updates the current view.
   */
  void refresh();

  /**
   * Sets the action listeners for the visual view.
   */
  void addFeatures(FeaturesMain featuresMainListener);

//  void addMouseListener(MouseListener ml);
//
//  void addActionListener(ActionListener actionListener);
//
//  void addKeyListener(KeyListener kl);

  /**
   * Highlights a certain given cell.
   *
   * @param c Coord object with cell coordinates
   */
  void highlightCell(Coord c);

  void moveX(int i);

  void moveY(int i);

  void resetFocus();

  Coord selectCell(int x, int y);

  void setText(String s);

  void setModel(ViewWorksheet model);

  String getOpenFile();

  String getSaveFile();
}
