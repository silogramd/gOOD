package edu.cs3500.spreadsheets.model;

/**
 * Interface for CellContents that are solely values.
 */
public abstract class CellValue implements Formula {

  /**
   * Combines this value with the given value using the operation.
   *
   * @param acc The given other value.
   * @param o The operation to use.
   * @return The resulting value.
   */
  public CellValue combine(CellValue acc, Operation o) {
    return o.apply(acc, this);
  }

  @Override
  public CellValue getValue() {
    return this;
  }


}
