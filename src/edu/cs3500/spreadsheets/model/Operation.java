package edu.cs3500.spreadsheets.model;

/**
 * Interface for all operations.
 */
public interface Operation {

  /**
   * Runs the operation.
   *
   * @param cv1 the first cell val
   * @param cv2 the second cell val
   * @return the result
   */
  CellValue apply(CellValue cv1, CellValue cv2);


}
