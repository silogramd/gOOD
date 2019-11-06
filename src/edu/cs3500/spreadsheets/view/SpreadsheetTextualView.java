package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ICell;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpreadsheetTextualView implements SpreadsheetView{

  Appendable ap;
  BasicSpreadsheetModel model;

  public SpreadsheetTextualView(Appendable ap, BasicSpreadsheetModel model) {
    this.ap = ap;
    this.model = model;
  }


  @Override
  public String toString() {
    String s = "";

    Map<Coord, ICell> cells = model.getAllCells();

    for (Map.Entry<Coord, ICell> entry : cells.entrySet()) {
      s += entry.getKey().toString() + " " + entry.getValue().getRawValue() + "\n";

    }

    return s;
  }


  /**
   * Renders the spreadsheet view.
   */
  @Override
  public void render() throws IOException {

    ap.append(this.toString());

  }
}
