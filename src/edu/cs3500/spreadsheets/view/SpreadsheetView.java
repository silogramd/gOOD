package edu.cs3500.spreadsheets.view;

import java.io.IOException;

/**
 * Interface for all spreadsheet views.
 */
public interface SpreadsheetView<K> {

  /**
   * <p>Renders the spreadsheet view.</p>
   */
  void render() throws IOException;

  /**
   * <p>Refreshes the view.</p>
   *
   * @throws IOException if fails to refresh.
   */
  void refresh() throws IOException;
}
