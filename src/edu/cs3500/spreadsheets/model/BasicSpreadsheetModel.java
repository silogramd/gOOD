package edu.cs3500.spreadsheets.model;

import java.util.HashMap;

/**
 * Represents a basic version of a spreadsheet model
 */
public class BasicSpreadsheetModel implements SpreadsheetModel<BasicCell> {

  private HashMap<Coord, BasicCell> hashMap = new HashMap<>();

  @Override
  public String getCellAt(Coord coord) {
    if(hashMap.containsKey(coord)) {
      return hashMap.get(coord).getValue();
    } else {
      throw new IllegalArgumentException("empty cell");
    }
  }

  @Override
  public String getRawCellAt(Coord coord) {
    if(hashMap.containsKey(coord)) {
      return hashMap.get(coord).getRawValue();
    } else {
      throw new IllegalArgumentException("empty cell");
    }
  }

  @Override
  public void editCell(Coord coord, String string) {

    //todo
    /*
    if(!(hashMap.containsKey(coord))) {
      hashMap.put(coord, string);
    } else {
      hashMap.replace(coord, string);
    }
    */

  }




}
