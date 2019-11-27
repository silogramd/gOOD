package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.ReadOnlyModel;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Frame view for a spreadsheet model. Basic gui.
 */
public class SpreadsheetFrameView extends JFrame implements SpreadsheetView {

  private static int WIDTH = 15;
  private static int HEIGHT = 30;
  JTextField[][] fieldGrid;
  private SpreadsheetGUIViewPanel panel;

  /**
   * Constructor that takes a read only model.
   *
   * @param model to be displayed
   */
  public SpreadsheetFrameView(ReadOnlyModel model) {
    super();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

}

