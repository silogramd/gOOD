package edu.cs3500.spreadsheets.model;

public class CompareObject implements Operation{

  @Override
  public CellValue apply(CellValue cv1, CellValue cv2) {
    try {
      return new CVBool(Double.valueOf(cv1.toString()) <
          Double.valueOf(cv2.toString()));
    } catch (NumberFormatException nfe) {
      return new CVError();
    }
  }

}
