package edu.cs3500.spreadsheets.model;

/**
 * <p>Class representing Concat function.</p>
 */
public class ConcatObject implements Operation {

  @Override
  public CellValue apply(CellValue cv1, CellValue cv2) {
    return new CVString(cv1.toString() + cv2.toString());
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof ConcatObject)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public int hashCode() {
    return 3;
  }
}
