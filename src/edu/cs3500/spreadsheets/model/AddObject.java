package edu.cs3500.spreadsheets.model;

/**
 * <p>Class representing the Add function.</p>
 */
public class AddObject implements Operation {

  @Override
  public CellValue apply(CellValue cv1, CellValue cv2) {
    double val1;
    double val2;

    if (cv1 instanceof CVBlank) {
      val1 = 0;
    } else {
      try {
        val1 = Double.parseDouble(cv1.toString());
      } catch (NumberFormatException e) {
        return new CVError();
      }
    }

    if (cv2 instanceof CVBlank) {
      val2 = 0;
    }  else {
      try {
        val2 = Double.parseDouble(cv2.toString());
      } catch (NumberFormatException e) {
        return new CVError();
      }
    }

    return new CVDouble(val1 + val2);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    return other instanceof AddObject;
  }

  @Override
  public int hashCode() {
    return 1;
  }

}
