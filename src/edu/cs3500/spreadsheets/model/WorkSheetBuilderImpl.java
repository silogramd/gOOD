package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import java.util.ArrayList;

/***
 * Implementation of the Builder for the Worksheet Reader.
 */
public class WorkSheetBuilderImpl implements WorksheetBuilder<BasicSpreadsheetModel> {

  ArrayList<ICell> cells = new ArrayList<>();

  @Override
  public WorksheetBuilder<BasicSpreadsheetModel> createCell(int col, int row, String contents) {
    ICell cell = new Cell(row, col, contents);
    cells.add(cell);
    return this;
  }

  @Override
  public BasicSpreadsheetModel createWorksheet() {
    return new BasicSpreadsheetModel(cells);
  }
}
