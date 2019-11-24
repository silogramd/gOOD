package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.ReadOnlyModel;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SpreadsheetEditableView extends JFrame implements SpreadsheetGUIView {

  private static int WIDTH = 15;
  private static int HEIGHT = 30;
  private final SpreadsheetModel<Cell> model;
  private SpreadsheetGUIViewPanel panel;
  private final JTextField[][] textGrid;
  private ViewEventListener listener;

  /**
   * Constructor that takes a read only model.
   *
   * @param model to be displayed
   */
  public SpreadsheetEditableView(SpreadsheetModel<Cell> model, ViewEventListener v) {
    super();
    this.listener = listener;
    this.model = model;

    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    textGrid = new JTextField[HEIGHT][WIDTH];

    panel = new SpreadsheetGUIViewPanel(model, WIDTH, HEIGHT);

    this.add(panel, BorderLayout.CENTER);
    this.pack();
    this.setLocationByPlatform(true);


    addListeners();
  }

  /**
   * Adds the {@link ViewEventListener} as a listener for the textgrid.
   */
  private void addListeners() {
    for (int i = 0; i < HEIGHT; i++) {
      for (int j = 0; j < WIDTH; j++) {
        listener.addTextEvent(textGrid[i][j]);
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
    this.pack();
    this.repaint();
  }

  /*
  @Override
  public int getHeight() {
    return sheet.getHeight();
  }

  @Override
  public int getWidth() {
    return sheet.getWidth();
  }
  */
}
