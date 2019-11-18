package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.ReadOnlyModel;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SpreadsheetEditableView extends JFrame implements SpreadsheetGUIView{

  private final SpreadsheetModel model;
  private final SpreadsheetFrameView sheet;
  private final JTextField[][] textGrid;
  private ViewEventListener listener;

  /**
   * Constructor that takes a read only model.
   *
   * @param model to be displayed
   */
  public SpreadsheetEditableView(SpreadsheetModel model, ViewEventListener v) {
    this.listener = listener;
    this.model = model;
    this.sheet = new SpreadsheetFrameView(new ReadOnlyModel(this.model));
    this.textGrid = this.sheet.fieldGrid;
    addListeners();
  }

  /**
   * Adds the {@link ViewEventListener} as a listener for the textgrid.
   */
  private void addListeners() {
    for (int i = 0; i < sheet.getHeight(); i++) {
      for (int j = 0; j < sheet.getWidth(); j++) {
        listener.addTextEvent(textGrid[i][j]);
      }
    }
  }


  @Override
  public void render() throws IOException {
    
  }

  @Override
  public void refresh() throws IOException {

  }

  @Override
  public int getHeight() {
    return sheet.getHeight();
  }

  @Override
  public int getWidth() {
    return sheet.getWidth();
  }
}
