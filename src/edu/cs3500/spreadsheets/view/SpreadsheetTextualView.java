package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.io.IOException;
import java.util.Map;

/**
 * <p>Textual View for a {@link SpreadsheetModel}.</p>
 */
public class SpreadsheetTextualView implements SpreadsheetView<Cell> {

  private Appendable ap;
  private SpreadsheetModel<Cell> model;

  /**
   * <p>Constructor for the TextualView.</p>
   *
   * @param ap    the {@link Appendable} where the view is written.
   * @param model the {@link SpreadsheetModel}.
   */
  public SpreadsheetTextualView(Appendable ap, SpreadsheetModel<Cell> model) {
    this.ap = ap;
    this.model = model;
  }


  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    Map<Coord, Cell> cells = model.getAllCells();

    for (Map.Entry<Coord, Cell> entry : cells.entrySet()) {
      s.append(entry.getKey().toString()).append(" ").append(entry.getValue().getRawValue())
          .append("\n");

    }

    return s.toString();
  }

  @Override
  public void render() throws IOException {

    ap.append(this.toString());

  }

  @Override
  public void refresh() throws IOException {
    ap.append(this.toString());
  }
}
