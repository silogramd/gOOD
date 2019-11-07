package edu.cs3500.spreadsheets.view;

import java.io.IOException;

/**
 * Interface for all spreadsheet views.
 */
public interface SpreadsheetView {

  /**
   * Renders the spreadsheet view.
   */
  void render() throws IOException;

  void refresh();
}
