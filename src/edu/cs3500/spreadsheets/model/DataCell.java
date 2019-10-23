package edu.cs3500.spreadsheets.model;

/**
 * Represents a basic data cell with one field of data.
 */
public class DataCell implements BasicCell {

  private String data;
  private Coord coord;

  /**
   * Default constructor.
   *
   * @param coord
   * @param data
   */
  public DataCell(Coord coord, String data) {
    this.data = data;
    this.coord = coord;
  }


  /**
   * Gets the value of this cell as a string.
   *
   * @return the value
   */
  @Override
  public String getValue() {
    return this.data;
  }

  /**
   * Gets the raw value of this cell as a string.
   *
   * @return the raw value
   */
  @Override
  public String getRawValue() {
    return this.data;
  }

  /**
   * Gets the coordinates of this cell.
   *
   * @return string format of the coordinates of this cell
   */
  @Override
  public String getCoord() {
    return String.format(Coord.colIndexToName(coord.col) + coord.row);
  }
}
