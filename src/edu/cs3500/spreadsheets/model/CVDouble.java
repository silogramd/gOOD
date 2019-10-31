package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

/**
 * <p>Class representing a double cell value.</p>
 */
public class CVDouble extends CellValue {

  private final double contents;

  public CVDouble(double d) {
    this.contents = d;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(this);
  }

  @Override
  public String toString() {
    return String.format("%f", this.contents);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof CVDouble)) {
      return false;
    }

    CVDouble o = (CVDouble)other;

    return (Math.abs(this.contents - o.contents) < 0.0001);
  }

  @Override
  public int hashCode() {
    Double d = this.contents;
    return d.hashCode();
  }
}
