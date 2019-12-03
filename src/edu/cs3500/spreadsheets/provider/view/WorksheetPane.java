package edu.cs3500.spreadsheets.provider.view;

//import java.awt.event.ActionListener;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseListener;

import edu.cs3500.spreadsheets.controller.FeaturesMain;
import edu.cs3500.spreadsheets.model.Coord;

import edu.cs3500.spreadsheets.provider.model.ViewWorksheet;

public interface WorksheetPane {
  Coord getTopLeft();
  void moveX(int x);
  void moveY(int y);
  void highlightCell(Coord c);
  void addFeatures(FeaturesMain f);

  Coord selectCell(int x, int y);

//  void addActionListener(ActionListener actionListener);

  void setModel(ViewWorksheet model);
//  void addKeyListener(KeyListener kl);

}
