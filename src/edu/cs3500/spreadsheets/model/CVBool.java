package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.Set;

/**
 * <p>Class representing a boolean Cell Value.</p>
 */
public class CVBool extends CellValue {
  private final boolean content;

  public CVBool(boolean b) {
    this.content = b;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(this);
  }

  @Override
  public String toString() {
    return String.valueOf(this.content);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof CVBool)) {
      return false;
    }

    CVBool o = (CVBool) other;

    return (this.content == o.content);
  }

  @Override
  public int hashCode() {
    if(content) {
      return 1;
    } else {
      return 0;
    }
  }
}
