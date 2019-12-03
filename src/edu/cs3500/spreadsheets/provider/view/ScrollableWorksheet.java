package edu.cs3500.spreadsheets.provider.view;

import edu.cs3500.spreadsheets.provider.model.ViewWorksheet;
import java.awt.*;
//import java.awt.event.ActionListener;

import javax.swing.*;

import edu.cs3500.spreadsheets.controller.FeaturesMain;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ViewWorksheet;

class ScrollableWorksheet extends JPanel implements WorksheetPane{
  private WorksheetPanel worksheetPanel;


  ScrollableWorksheet(ViewWorksheet model){
    WorksheetPanel.WorksheetPanelBuilder builder = new WorksheetPanel.WorksheetPanelBuilder();
    builder.setModel(model);

    this.worksheetPanel = builder.buildWorksheet();
    //this.values = model.getAllValues();
    //Coord topLeftCoord = new Coord(1, 1);
    JScrollBar vertical = new JScrollBar(JScrollBar.VERTICAL, 1, 100, 1, 600);
    JScrollBar horizontal = new JScrollBar(JScrollBar.HORIZONTAL, 1, 100, 1, 600);
    vertical.addAdjustmentListener(worksheetPanel);
    horizontal.addAdjustmentListener(worksheetPanel);
    GridBagConstraints gbc = new GridBagConstraints();
    setLayout(new GridBagLayout());

    gbc.anchor = GridBagConstraints.PAGE_START;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = .5;
    gbc.weighty = .5;
    gbc.fill = GridBagConstraints.BOTH;
    add(this.worksheetPanel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 0;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.VERTICAL;
    add(vertical, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 1;
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(horizontal, gbc);

  }

  @Override
  public Coord getTopLeft() {
    return this.worksheetPanel.getTopLeft();
  }

  @Override
  public void moveX(int x) {

  }

  @Override
  public void moveY(int y) {

  }

  @Override
  public void highlightCell(Coord c) {
    this.worksheetPanel.highlightCell(c);
  }

  @Override
  public void addFeatures(FeaturesMain f) {

  }

  @Override
  public Coord selectCell(int x, int y) {
    return this.worksheetPanel.selectCell(x,y);
  }

//  @Override
//  public void addActionListener(ActionListener actionListener) {
//
//  }

  @Override
  public void setModel(ViewWorksheet model) {
    this.worksheetPanel.setModel(model);
  }
//
//  @Override
//  public void addKeyListener(KeyListener kl) {
//    this.worksheetPanel.addKeyListener(kl);
//  }


}