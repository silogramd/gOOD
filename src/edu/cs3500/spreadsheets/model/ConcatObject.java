package edu.cs3500.spreadsheets.model;

public class ConcatObject implements Operation {

  @Override
  public CellValue apply(CellValue cv1, CellValue cv2) {
    if (!((cv1 instanceof CVString) && (cv2 instanceof CVString))) {
      return new CVError();
    }
    return new CVString(((CVString) cv1).contents + ((CVString) cv2).contents);
  }
}
