package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ReadOnlyModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonAreaLayout;

/**
 * Frame view for a spreadsheet model.
 */
public class SpreadsheetFrameView extends JFrame implements SpreadsheetGUIView {

  private static int WIDTH = 15;
  private static int HEIGHT = 30;
  JTextField[][] fieldGrid;
  private ReadOnlyModel model;
  private SpreadsheetGUIViewPanel panel;

  /**
   * Constructor that takes a read only model.
   *
   * @param model to be displayed
   */
  public SpreadsheetFrameView(ReadOnlyModel model) {
    super();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.model = model;
    this.setLayout(new BorderLayout());

    fieldGrid = new JTextField[HEIGHT][WIDTH];

    panel = new SpreadsheetGUIViewPanel(model, WIDTH, HEIGHT);

    this.add(panel, BorderLayout.CENTER);
    this.pack();
    this.setLocationByPlatform(true);
  }



  /**
   * Renders the spreadsheet view.
   */
  @Override
  public void render() throws IOException {
    setVisible(true);
  }

  @Override
  public void refresh() {
    this.panel.refresh();
    this.pack();
    this.repaint();
  }



  // IF WE NEED THESE LATER WE NEED TO RENAME THEM BECAUSE THEY BREAK THE PANEL!!!
  /*
  @Override
  public int getHeight() {
    return this.HEIGHT;
  }

  @Override
  public int getWidth() {
    return this.WIDTH;
  }
  */
}

