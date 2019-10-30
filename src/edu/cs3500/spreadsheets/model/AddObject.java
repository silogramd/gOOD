package edu.cs3500.spreadsheets.model;

public class AddObject implements Operation {

  @Override
  public CellValue apply(CellValue cv1, CellValue cv2) {
    try {
      return new CVDouble(Double.valueOf(cv1.toString())
          + Double.valueOf(cv2.toString()));
    } catch (NumberFormatException e) {
      return new CVError();
    }
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof AddObject)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public int hashCode() {
    return 1;
  }

}
