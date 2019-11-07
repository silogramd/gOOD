package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.CellValue;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ICell;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SpreadsheetFrameView extends JFrame implements SpreadsheetView {

  private static int WIDTH = 20;
  private static int HEIGHT = 20;
  private int rowOffset;
  private int colOffset;
  private static final Color BG = Color.DARK_GRAY;
  private JTextField[][] fieldGrid = new JTextField[HEIGHT][WIDTH];
  private SpreadsheetModel<Cell> model;

  public SpreadsheetFrameView(SpreadsheetModel<Cell> model) {
    this.model = model;
    this.rowOffset = 0;
    this.colOffset = 0;

    JPanel mainPanel = new JPanel(new GridLayout(HEIGHT, WIDTH));
    fillGrid(mainPanel);
    JPanel rows = new JPanel();
    JPanel cols = new JPanel();


    this.add(cols, BorderLayout.NORTH);
    this.add(rows, BorderLayout.WEST);
    this.add(mainPanel, BorderLayout.CENTER);
    this.pack();
  }

  // fills the grid
  private void fillGrid(JPanel panel) {

    Cell curCell;
    String curText;
    JTextField field;

    for (int i = 1; i <= WIDTH; i++) {
      for (int j = 1; j <= HEIGHT; j++) {
        curCell = model.getCellAt(new Coord(j + colOffset, i + rowOffset));
        curText = curCell.getValue().toString();
        field = new JTextField(curText, 10);
        //field.setText(curText);
        //field.setColumns(10);
        panel.add(field);
      }
    }
  }



  /**
   * Renders the spreadsheet view.
   */
  @Override
  public void render() throws IOException {
    SpreadsheetModel<Cell> model = new BasicSpreadsheetModel();
    SpreadsheetFrameView mainPanel = new SpreadsheetFrameView(model);
    mainPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    mainPanel.pack();
    mainPanel.setLocationByPlatform(true);
    mainPanel.setVisible(true);
  }


  public static void main(String[] args) throws IOException {
    SpreadsheetModel<Cell> model = new BasicSpreadsheetModel();
    SpreadsheetFrameView view = new SpreadsheetFrameView(model);
    view.render();
  }
}

