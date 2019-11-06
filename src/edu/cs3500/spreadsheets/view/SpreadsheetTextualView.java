package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ICell;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpreadsheetTextualView implements SpreadsheetView{

  private Appendable ap;
  private BasicSpreadsheetModel model;

  public SpreadsheetTextualView(Appendable ap, BasicSpreadsheetModel model) {
    this.ap = ap;
    this.model = model;
  }


  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    Map<Coord, ICell> cells = model.getAllCells();

    for (Map.Entry<Coord, ICell> entry : cells.entrySet()) {
      s.append(entry.getKey().toString()).append(" ").append(entry.getValue().getRawValue())
          .append("\n");

    }

    return s.toString();
  }


  /**
   * Renders the spreadsheet view.
   */
  @Override
  public void render() throws IOException {

    ap.append(this.toString());

  }
}
