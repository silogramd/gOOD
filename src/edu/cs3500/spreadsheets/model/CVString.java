package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVString extends CellValue {

  private final String contents;

  public CVString(String s) {
    this.contents = s;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(this);
  }

  @Override
  public String toString() {
    return this.contents;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof CVString)) {
      return false;
    }

    CVString o = (CVString) other;

    return this.contents.equals(o.contents);
  }

  @Override
  public int hashCode() {
    return this.contents.hashCode();
  }
}
