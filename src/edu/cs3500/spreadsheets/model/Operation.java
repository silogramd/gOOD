package edu.cs3500.spreadsheets.model;

/**
 * <p>A function object representing a function that can be applied in a cell.</p>
 */
public interface Operation {

  /**
   * Applies the function to the two CellValues.
   * @param cv1 the first CellValue.
   * @param cv2 the second CellValue.
   * @return the new CellValue.
   */
  CellValue apply(CellValue cv1, CellValue cv2);


}
