package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import java.util.ArrayList;

/**
 * Implementation of the Builder for the Worksheet Reader.
 */
public class WorkSheetBuilderImpl implements WorksheetBuilder<BasicSpreadsheetModel> {

  BasicSpreadsheetModel model = new BasicSpreadsheetModel();

  @Override
  public WorksheetBuilder<BasicSpreadsheetModel> createCell(int row, int col, String contents) {
    model.editCell(new Coord(col, row), contents);
    return this;
  }

  @Override
  public BasicSpreadsheetModel createWorksheet() {
    return model;
  }
}
