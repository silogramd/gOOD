package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a basic version of a spreadsheet model
 */
public class BasicSpreadsheetModel implements SpreadsheetModel<ICell> {

  static final HashMap<Coord, ICell> coordMap = new HashMap<>();

  BasicSpreadsheetModel(ArrayList<ICell> cells) {
    for (ICell c: cells) {
      coordMap.put(c.getCoord(), c);
    }

    for (ICell c: cells) {
      c.checkCycles(new ArrayList<>());
    }
  }

  public BasicSpreadsheetModel() {}

  @Override
  public ICell getCellAt(Coord coord) {

    try {
      return coordMap.get(coord);
    } catch (NullPointerException e) {
      return new Cell(coord);
    }
  }

  @Override
  public String getRawCellAt(Coord coord) {
    try {
      return coordMap.get(coord).getRawValue();
    } catch (NullPointerException e) {
      return new Cell(coord).getRawValue();
    }
  }



  @Override
  public void editCell(Coord coord, String string) {

    coordMap.put(coord, new Cell(coord, string));
  }
}
