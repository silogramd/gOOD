package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Editable version of a gui view. Adds view event listeners and focus listeners to allow user
 * to edit cells in the model.
 */
public class SpreadsheetEditableView extends JFrame implements SpreadsheetView, FocusListener {

  private static int WIDTH = 15;
  private static int HEIGHT = 30;
  private SpreadsheetGUIViewPanel panel;
  private final CoordTextField[][] textGrid;
  private ViewEventListener listener;
  private editPanel ePanel = new editPanel();

  /**
   * Constructor that takes a read only model.
   *
   * @param model to be displayed
   */
  public SpreadsheetEditableView(SpreadsheetModel model, ViewEventListener v) {
    super();
    this.listener = v;

    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());
    panel = new SpreadsheetGUIViewPanel(model, WIDTH, HEIGHT);
    textGrid = fillGrid();
    this.add(ePanel, BorderLayout.NORTH);
    this.add(panel, BorderLayout.SOUTH);
    this.pack();
    this.setLocationByPlatform(true);


    addListeners();
  }

  /**
   * Helper method to fill the grid of text fields.
   *
   * @return A 2d array of text fields.
   */
  private CoordTextField[][] fillGrid() {
    CoordTextField[][] grid = new CoordTextField[HEIGHT][WIDTH];
    for (int i = 0; i < HEIGHT; i++) {
      for (int k = 0; k < WIDTH; k++) {
        grid[i][k] = new CoordTextField(panel.fieldGrid[i][k], i, k);
      }
    }
    return grid;
  }

  /**
   * Adds the {@link ViewEventListener} as a listener for the textgrid.
   */
  private void addListeners() {
    for (int i = 0; i < HEIGHT; i++) {
      for (int j = 0; j < WIDTH; j++) {
        textGrid[i][j].field.addFocusListener(this);
      }
    }
  }


  @Override
  public void render() throws IOException {
    this.setVisible(true);
  }

  @Override
  public void refresh() throws IOException {
    this.panel.refresh();
    setWhite();
    this.pack();
    this.repaint();
  }

  /**
   * Sets all the textfields to have a white background.
   */
  private void setWhite() {
    for (int i = 0; i < HEIGHT; i++) {
      for (int k = 0; k < WIDTH; k++) {
        textGrid[i][k].field.setBackground(Color.WHITE);
      }
    }
  }

  @Override
  public void focusGained(FocusEvent e) {
    //this is a safe cast. the only objects gaining focus will be textfields.
    setWhite();
    JTextField field = (JTextField) e.getComponent();
    field.setBackground(Color.CYAN);
    System.out.print(field.getText());
    ePanel.setEditableCell(getCoord(field));
  }

  /***
   * Gets the coordinate of the cell being represented by the input textfield.
   * @param field the textfield whose contents' coordinates are being queried.
   * @return the coordinates of the cell.
   */
  private Coord getCoord(JTextField field) {
    int row = -1;
    int col = -1;
    boolean found = false;
    for (int i = 0; i < HEIGHT; i++) {
      if (!found) {
      for (int k = 0; k < WIDTH; k++) {
        if (textGrid[i][k].field.equals(field)) {
          row = i;
          col = k;
          found = true;
          break;
        }
      }
      } else {
        break;
      }
    }
    if (row == -1 || col == -1) {
      throw new IllegalStateException("Textfield is not in the grid.");
    }
    return new Coord(col + panel.colOffset + 1,row + panel.rowOffset + 1);
  }

  @Override
  public void focusLost(FocusEvent e) {
    // Do nothing, focus will be lost when user clicks into the editing bar.
  }

  /**
   * Panel at the top of the UI that allows for editing of the contents of cells.
   */
  private class editPanel extends JPanel implements ActionListener{

    JButton confirm = new JButton("Confirm");
    JTextField newText = new JTextField(30);

    /**
     * Default constructor for the edit panel bar.
     */
    editPanel() {
      super(new GridLayout(1,2));
      this.add(confirm);
      confirm.addActionListener(this);
      this.add(newText);
      newText.setEditable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      listener.confirmEdits(newText.getText());
      try {
        SpreadsheetEditableView.this.refresh();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    /**
     * Changes the current highlighted cell.
     * @param coord to highlight
     */
    void setEditableCell(Coord coord) {
      listener.setEditableCoord(coord);
      Cell c = listener.getEditableCell();
      newText.setText(c.getRawValue());
    }

  }
}
