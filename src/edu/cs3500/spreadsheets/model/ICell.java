package edu.cs3500.spreadsheets.model;

/**
 * Interface for a Cell in a spreadsheet.
 */
public interface ICell {

  /**
   * Gets the value of the Cell
   * @return the CellValue associated with the cell.
   */
  CellValue getValue();

  /**
   * Gets the raw string value of the cell.
   * @return the raw string
   */
  String getRawValue();

  /**
   * Gets the coord associated with the cell.
   * @return the coord.
   */
  Coord getCoord();

  void update(String contents);

  void addReferencedBy(Coord other);

  void removeReferencedBy(Coord other);

  void refresh();
}
