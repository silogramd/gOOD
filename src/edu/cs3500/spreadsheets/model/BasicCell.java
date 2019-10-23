package edu.cs3500.spreadsheets.model;

/**
 * Represents a basic implementation of a cell
 */
public interface BasicCell {

  /**
   * Gets the value of the cell.
   *
   * @return the string value of the cell.
   */
  String getValue();

  /**
   * Gets the raw value of the cell.
   *
   * @return raw string value of the cell
   */
  String getRawValue();

  /**
   * Get the coordinates of the cell. Used in getRawValue in formula cells.
   *
   * @return string coordinates of the cell.
   */
  String getCoord();
}
