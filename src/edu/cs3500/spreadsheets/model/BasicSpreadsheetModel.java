package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a basic version of a spreadsheet model
 */
public class BasicSpreadsheetModel implements SpreadsheetModel<ICell> {

  static HashMap<Coord, ICell> coordMap = new HashMap<>();

  BasicSpreadsheetModel(ArrayList<ICell> cells) {
    for (ICell c: cells) {
      coordMap.put(c.getCoord(), c);
    }

  }

  public BasicSpreadsheetModel() {}

  @Override
  public CellValue getCellAt(Coord coord) {
    //debuging
    System.out.println(coordMap.toString());


    try {
      return coordMap.get(coord).getValue();
    } catch (NullPointerException e) {
      return new Cell(coord).getValue();
    }
  }



  @Override
  public void editCell(Coord coord, String string) {

    coordMap.put(coord, new Cell(coord, string));
  }
}
