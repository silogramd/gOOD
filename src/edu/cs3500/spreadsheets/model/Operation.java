package edu.cs3500.spreadsheets.model;

public interface Operation {

  CellValue apply(CellValue cv1, CellValue cv2);


}
