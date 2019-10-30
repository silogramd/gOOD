package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVError extends CellValue {

  @Override
  public CellValue combine(CellValue acc, Operation o) {
    return this;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(this);
  }

  @Override
  public String toString() {
    return "#ERROR";
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof CVError)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public int hashCode() {
    return 9;
  }
}
