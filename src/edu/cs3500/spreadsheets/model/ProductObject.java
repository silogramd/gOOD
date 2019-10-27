package edu.cs3500.spreadsheets.model;

public class ProductObject implements Operation {

  @Override
  public CellValue apply(CellValue cv1, CellValue cv2) {
    if (!((cv1 instanceof CVDouble) && (cv2 instanceof CVDouble))) {
      return new CVError();
    }
    return new CVDouble(((CVDouble) cv1).contents * ((CVDouble) cv2).contents);
  }
}
