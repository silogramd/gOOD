package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;

/**
 *  Interface for the model of spreadsheets
 */
public interface SpreadsheetModel {

  public String getCellAt(Coord coord);

  public String handleFunction(Coord cord, String cur);

  public String getRawCellAt(Coord coord);

  public void editCell(Coord coord, String string);

}
