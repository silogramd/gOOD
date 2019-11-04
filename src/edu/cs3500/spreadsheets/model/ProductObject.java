package edu.cs3500.spreadsheets.model;

import java.util.List;

/**
 * Represents a multiplication object.
 */
public class ProductObject implements Operation, CellValueVisitor<Double> {

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
    return 1.0;
  }

  @Override
  public Double visitBool(CVBool cv) {
    return 1.0;
  }

  @Override
  public Double visitString(CVString cv) {
    return 1.0;
  }

  @Override
  public CellValue apply(List<CellValue> vals) {
    Double outpt = 1.0;
    for (CellValue v: vals) {
      try {
        outpt *= v.accept(this);
      } catch (IllegalStateException e) {
        return new CVError();
      }
    }
    return new CVDouble(outpt);
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
