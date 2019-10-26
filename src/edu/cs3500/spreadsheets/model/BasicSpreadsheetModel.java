package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

/**
 * Represents a basic version of a spreadsheet model
 */
public class BasicSpreadsheetModel implements SpreadsheetModel<ICell> {

  static BiMap<Coord, ICell> coordMap = new BiMap<>();

  BasicSpreadsheetModel(ArrayList<ICell> cells) {
    for (ICell c: cells) {
      coordMap.put(c.getCoord(), c);
    }
  }

  public BasicSpreadsheetModel() {}

  @Override
  public String getCellAt(Coord coord) {
    return null;
  }



  @Override
  public void editCell(Coord coord, String string) {

  }
}
