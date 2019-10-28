package edu.cs3500.spreadsheets.model;

public class AddObject implements Operation {

  @Override
  public CellValue apply(CellValue cv1, CellValue cv2) {
    if (!((cv1 instanceof CVDouble) && (cv2 instanceof CVDouble))) {
      return new CVError();
    }

    System.out.println("made it inside add: " + cv1.toString() + " + " + cv2.toString());

    return new CVDouble(((CVDouble) cv1).contents + ((CVDouble) cv2).contents);
  }
}
