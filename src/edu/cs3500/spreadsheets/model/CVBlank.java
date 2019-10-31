package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

/**
 * <p>Class representing a blank CellValue tests.</p>
 */
public class CVBlank extends CellValue {


  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    //do nothing! if value is blank, there is nothing to flatten.
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof CVBlank)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public int hashCode() {
    return 6;
  }
}
