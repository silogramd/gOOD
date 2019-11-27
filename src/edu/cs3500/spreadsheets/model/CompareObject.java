package edu.cs3500.spreadsheets.model;

import java.util.List;

/**
 * <p>Class representing the Compare function. Throws errors if not a CVDouble.</p>
 */
public class CompareObject implements Operation, CellValueVisitor<Double> {

  @Override
  public Double visitDouble(CVDouble cv) {
    return Double.valueOf(cv.toString());
  }

  @Override
  public Double visitError(CVError cv) {
    throw new IllegalStateException();
  }

  @Override
  public Double visitBlank(CVBlank cv) {
    throw new IllegalStateException();
  }

  @Override
  public Double visitBool(CVBool cv) {
    throw new IllegalStateException();
  }

  @Override
  public Double visitString(CVString cv) {
    throw new IllegalStateException();
  }

  @Override
  public CellValue apply(List<CellValue> vals) {
    if (vals.size() != 2) {
      return new CVError();
    }
    try {
      boolean outpt = vals.get(0).accept(this) < vals.get(1).accept(this);
      return new CVBool(outpt);
    } catch (IllegalStateException e) {
      return new CVError();
    }
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    return other instanceof CompareObject;
  }

  @Override
  public int hashCode() {
    return 2;
  }
}
