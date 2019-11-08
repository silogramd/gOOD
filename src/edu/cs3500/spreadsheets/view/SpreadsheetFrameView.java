package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpreadsheetFrameView extends JFrame implements SpreadsheetView {

  private static int WIDTH = 15;
  private static int HEIGHT = 30;
  private static int scrollLength = 10;
  private int rowOffset;
  private int colOffset;
  private static final Color BG = Color.DARK_GRAY;
  private JTextField[][] fieldGrid = new JTextField[HEIGHT][WIDTH];
  private SpreadsheetModel<Cell> model;
  private JPanel mainPanel;
  private JPanel rows;
  private JPanel cols;
  private JPanel xButtons;
  private JPanel yButtons;

  public SpreadsheetFrameView(SpreadsheetModel<Cell> model) {
    this.model = model;
    this.rowOffset = 0;
    this.colOffset = 0;

    this.mainPanel = new JPanel(new GridLayout(HEIGHT, WIDTH));
    fillGrid(mainPanel);

    this.rows = new JPanel(new GridLayout(HEIGHT, 1));
    this.cols = new JPanel(new GridLayout(1, WIDTH + 1));
    fillCoords(rows, cols);


    this.xButtons = new JPanel(new GridLayout(1,2));
    this.yButtons = new JPanel(new GridLayout(2,1));
    createXButtons(xButtons);
    createYButtons(yButtons);

    this.add(cols, BorderLayout.NORTH);
    this.add(rows, BorderLayout.WEST);
    this.add(mainPanel, BorderLayout.CENTER);
    this.add(xButtons, BorderLayout.SOUTH);
    this.add(yButtons, BorderLayout.EAST);


    this.addKeyListener(new ScrollHandler());
    this.pack();
  }


  //creates x buttons
  private void createXButtons(JPanel xButtons) {
    JButton left = new JButton("Left");
    JButton right = new JButton("Right");
    JButton reset = new JButton("Reset");

    left.addActionListener(e -> scroll("left"));
    right.addActionListener(e -> scroll("right"));
    reset.addActionListener(e -> scroll("Reset"));

    xButtons.add(reset);
    xButtons.add(left);
    xButtons.add(right);
  }

  //creates y buttons
  private void createYButtons(JPanel yButtons) {
    JButton up = new JButton("Up");
    JButton down = new JButton("Down");



    up.addActionListener(e -> scroll("up"));
    down.addActionListener(e -> scroll("down"));

    yButtons.add(up);
    yButtons.add(down);
  }


  /**
   * Fills the Coordinate headers with the row and column values.
   *
   */
  private void fillCoords(JPanel rows, JPanel cols) {
    rows.removeAll();
    cols.removeAll();

    for (int i = 0; i < WIDTH + 1; i++) {
      String col = Coord.colIndexToName(i + colOffset + 1);
      JTextField textfield = new JTextField(col);
      textfield.setEditable(false);
      textfield.setFocusable(false);
      cols.add(textfield);
    }

    for (int j = 0; j < HEIGHT; j++) {
      String row = Integer.toString(j + rowOffset + 1);
      JTextField textfield = new JTextField(row);
      textfield.setEditable(false);
      textfield.setFocusable(false);
      rows.add(textfield);
    }
  }

  /**
   * Fills the Grid with its Cells.
   *
   * @return JPanel the panel of Cells.
   */
  private void fillGrid(JPanel panel) {
    panel.removeAll();

    Cell curCell;
    String curText;

    for (int i = 0; i < HEIGHT; i++) {
      for (int j = 0; j < WIDTH; j++) {
        curCell = model.getCellAt(new Coord(j + colOffset + 1, i + rowOffset + 1));
        curText = curCell.getValue().toString();
        fieldGrid[i][j] = new JTextField(curText, 6);
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
        if (rowOffset - scrollLength >= 0) {
          rowOffset = rowOffset - scrollLength;
        }
        break;
      case "left":
        if (colOffset - scrollLength >= 0) {
          colOffset = colOffset - scrollLength;
        }
        break;
      case "right":
        colOffset += scrollLength;
        break;
      default:
        colOffset = 0;
        rowOffset = 0;
        break;
    }
    fillGrid(mainPanel);
    fillCoords(rows, cols);
    this.refresh();
  }

  /**
   * Renders the spreadsheet view.
   */
  @Override
  public void render() throws IOException {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.pack();
    this.setLocationByPlatform(true);
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    this.pack();
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

