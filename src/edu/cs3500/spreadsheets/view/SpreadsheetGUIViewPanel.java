package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpreadsheetGUIViewPanel extends JPanel {

  private static int WIDTH;
  private static int HEIGHT;
  private static int scrollLength = 10;
  private int rowOffset;
  private int colOffset;
  private static final Color BG = Color.DARK_GRAY;
  JTextField[][] fieldGrid;
  private JPanel mainPanel;
  private JPanel rows;
  private JPanel cols;
  private SpreadsheetModel<Cell> model;

  public SpreadsheetGUIViewPanel(SpreadsheetModel<Cell> model, int width, int height) {
    super(new BorderLayout());

    this.WIDTH = width;
    this.HEIGHT = height;

    this.model = model;
    this.colOffset = 0;
    this.rowOffset = 0;

    fieldGrid = new JTextField[HEIGHT][WIDTH];

    this.mainPanel = new JPanel(new GridLayout(HEIGHT, WIDTH));
    this.rows = new JPanel(new GridLayout(HEIGHT, 1));
    this.cols = new JPanel(new GridLayout(1, WIDTH + 1));

    this.build();
  }

  /**
   * Builds the GUI.
   */
  private void build() {
    fillGrid(mainPanel);
    fillCoords(rows, cols);

    JPanel xButtons = new JPanel(new GridLayout(1, 3));
    JPanel yButtons = new JPanel(new GridLayout(3, 1));
    createXButtons(xButtons);
    createYButtons(yButtons);

    this.add(cols, BorderLayout.NORTH);
    this.add(rows, BorderLayout.WEST);
    this.add(mainPanel, BorderLayout.CENTER);
    this.add(xButtons, BorderLayout.SOUTH);
    this.add(yButtons, BorderLayout.EAST);

   //this.refresh();
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
    JButton save = new JButton("Save");

    up.addActionListener(e -> scroll("up"));
    down.addActionListener(e -> scroll("down"));
    save.addActionListener(e -> saveHelp());

    yButtons.add(save);
    yButtons.add(up);
    yButtons.add(down);

  }

  private void saveHelp() {

    PrintWriter pw;
    File file = new File(this.model.toString() + ".txt");
    try {
      file.createNewFile();
      pw = new PrintWriter(new FileOutputStream(file, true));
    } catch (Exception ex) {
      throw new IllegalStateException("Cant open or make file");
    }

    SpreadsheetView<Cell> textView = new SpreadsheetTextualView(pw, model);

    try {
      textView.render();
    } catch (IOException ex) {
      throw new IllegalStateException("IOException");
    }

    pw.close();
  }


  /**
   * Fills the Coordinate headers with the row and column values.
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
    JTextField field;

    for (int i = 0; i < HEIGHT; i++) {
      for (int j = 0; j < WIDTH; j++) {
        System.out.println("i = " + i);
        System.out.println("j = " + i);
        System.out.println("coord = " + new Coord(j + colOffset + 1, i + rowOffset + 1).toString());
        System.out.println("cell = " + model.getCellAt(new Coord(j + colOffset + 1, i + rowOffset + 1)));
        curCell = model.getCellAt(new Coord(j + colOffset + 1, i + rowOffset + 1));
        curText = curCell.getValue().toString();

        field = new JTextField(curText, 6);
        fieldGrid[i][j] = field;
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


  public void refresh() {
    this.revalidate();
    this.repaint();
  }
}