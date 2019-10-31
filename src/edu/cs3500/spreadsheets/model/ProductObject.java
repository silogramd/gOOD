package edu.cs3500.spreadsheets.model;

/**
 * Represents a multiplication object.
 */
public class ProductObject implements Operation {

  /**
   * Multiplies the tow cell values into a new one.
   *
   * @param cv1 first cell value.
   * @param cv2 second cell value.
   * @return result cell value.
   */
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

    return new CVDouble(val1 * val2);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    return other instanceof ProductObject;
  }

  @Override
  public int hashCode() {
    return 4;
  }
}
