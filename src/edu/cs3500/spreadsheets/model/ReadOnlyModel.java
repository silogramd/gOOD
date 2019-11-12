package edu.cs3500.spreadsheets.model;

import java.util.Map;

/**
 * Read-only implementation of the {@link SpreadsheetModel} interface.
 */
public class ReadOnlyModel implements SpreadsheetModel<Cell> {

  private final SpreadsheetModel<Cell> model;

  /**
   * Constructor for the read-only model.
   *
   * @param model the internal model through which all reads take place.
   */
  public ReadOnlyModel(SpreadsheetModel<Cell> model) {
    this.model = model;
  }

  @Override
  public Cell getCellAt(Coord coord) {
    return model.getCellAt(coord);
  }

  @Override
  public String getRawCellAt(Coord coord) {
    return model.getRawCellAt(coord);
  }

  @Override
  public void editCell(Coord coord, String string) {

  }

  @Override
  public Map<Coord, Cell> getAllCells() {
    return model.getAllCells();
  }

  @Override
  public void clearSheet() {

  }

  @Override
  public String toString() {
    return this.model.toString();
  }
}
