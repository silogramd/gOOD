package edu.cs3500.spreadsheets.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a basic version of a spreadsheet model.
 */
public class BasicSpreadsheetModel implements SpreadsheetModel<ICell> {

  static HashMap<Coord, ICell> coordMap = new HashMap<>();
  
  @Override
  public ICell getCellAt(Coord coord) {
    ICell real = coordMap.getOrDefault(coord, new Cell(coord));
    ICell copy = new Cell(real.getCoord(), real.getRawValue());
    return copy;
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
    if (!coordMap.containsKey(coord)) {
      coordMap.put(coord, new Cell(coord, string));
    } else {
      coordMap.get(coord).update(string);
    }
  }

  @Override
  public Map<Coord, ICell> getAllCells() {
    return Map.copyOf(coordMap);
  }

  @Override
  public void clearSheet() {
    coordMap = new HashMap<>();

  }
}
