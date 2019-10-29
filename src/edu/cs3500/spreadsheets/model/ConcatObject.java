package edu.cs3500.spreadsheets.model;

public class ConcatObject implements Operation {

  @Override
  public CellValue apply(CellValue cv1, CellValue cv2) {
      return new CVString(cv1.toString() + cv2.toString());
  }

}
