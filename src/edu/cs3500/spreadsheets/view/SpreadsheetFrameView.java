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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SpreadsheetFrameView extends JFrame implements SpreadsheetView {

  private static int WIDTH = 20;
  private static int HEIGHT = 20;
  private static int scrollLength = 10;
  private int rowOffset;
  private int colOffset;
  private static final Color BG = Color.DARK_GRAY;
  private JTextField[][] fieldGrid = new JTextField[HEIGHT][WIDTH];
  private SpreadsheetModel<Cell> model;
  private JPanel mainPanel;
  private JPanel rows;
  private JPanel cols;

  public SpreadsheetFrameView(SpreadsheetModel<Cell> model) {
    this.model = model;
    this.rowOffset = 0;
    this.colOffset = 0;
    this.mainPanel = new JPanel(new GridLayout(HEIGHT, WIDTH));
    fillGrid(mainPanel);
    this.rows = new JPanel(new GridLayout(HEIGHT, 1));
    this.cols = new JPanel(new GridLayout(1, WIDTH));
    fillCoords(rows, cols);
    this.add(cols, BorderLayout.NORTH);
    this.add(rows, BorderLayout.WEST);
    this.add(mainPanel, BorderLayout.CENTER);
    this.addKeyListener(new ScrollHandler());
    this.pack();
  }

  /**
   * Fills the Coordinate headers with the row and column values.
   *
   * @param rows The Row Panel
   * @param cols The Column Panel
   */
  private void fillCoords(JPanel rows, JPanel cols) {
    for (int i = 0; i < WIDTH; i++) {
      String col = Coord.colIndexToName(i + colOffset + 1);
      JTextField textfield = new JTextField(col);
      textfield.setEditable(false);
      cols.add(textfield);
    }
    for (int j = 0; j < HEIGHT; j++) {
      String row = Integer.toString(j + rowOffset + 1);
      JTextField textfield = new JTextField(row);
      textfield.setEditable(false);
      rows.add(textfield);
    }
  }

  /**
   * Fills the Grid with its Cells.
   *
   * @param panel the panel of Cells.
   */
  private void fillGrid(JPanel panel) {

    Cell curCell;
    String curText;

    for (int i = 0; i < WIDTH; i++) {
      for (int j = 0; j < HEIGHT; j++) {
        curCell = model.getCellAt(new Coord(j + colOffset + 1, i + rowOffset + 1));
        curText = curCell.getValue().toString();
        fieldGrid[i][j] = new JTextField(curText, 10);
        //fieldGrid[i][j].setEditable(false);
        panel.add(fieldGrid[i][j]);
      }
    }
  }

  private void scroll(String direction) {
    switch (direction) {
      case "down":
        rowOffset += scrollLength;
        break;
      case "up":
        if (rowOffset - scrollLength < 0) {

        } else {
          rowOffset -= scrollLength;
        }
        break;
      case "left":
        if (colOffset - scrollLength < 0) {

        } else {
          colOffset -= scrollLength;
        }
        break;
      case "right":
        colOffset += scrollLength;
        break;
      default:
        break;
    }
    fillGrid(this.mainPanel);
    fillCoords(this.rows, this.cols);
    this.refresh();
  }

  /**
   * Renders the spreadsheet view.
   */
  @Override
  public void render() throws IOException {
    SpreadsheetFrameView mainPanel = new SpreadsheetFrameView(model);
    mainPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    mainPanel.pack();
    mainPanel.setLocationByPlatform(true);
    mainPanel.setVisible(true);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  //TODO: DELETE THIS! THIS IS NOT PERMANENT.
  public static void main(String[] args) throws IOException {
    SpreadsheetModel<Cell> model = new BasicSpreadsheetModel();
    SpreadsheetFrameView view = new SpreadsheetFrameView(model);
    view.render();
  }

  private class ScrollHandler implements KeyListener {

    private HashMap<Integer, Runnable> typedMap = new HashMap<>();

    ScrollHandler() {
      typedMap.put(KeyEvent.VK_DOWN, () -> {
        scroll("down");
      });
      typedMap.put(KeyEvent.VK_UP, () -> {
        scroll("up");
      });
      typedMap.put(KeyEvent.VK_RIGHT, () -> {
        scroll("right");
      });
      typedMap.put(KeyEvent.VK_LEFT, () -> {
        scroll("left");
      });
    }

    @Override
    public void keyTyped(KeyEvent e) {
      if (!typedMap.containsKey(e)) {

      } else {
        typedMap.get(e).run();
      }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
  }
}

