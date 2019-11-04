package edu.cs3500.spreadsheets.model;

import java.util.List;

/**
 * <p>Class representing the Add function.</p>
 */
public class AddObject implements Operation, CellValueVisitor<Double> {


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
    return 0.0;
  }

  @Override
  public Double visitBool(CVBool cv) {
    return 0.0;
  }

  @Override
  public Double visitString(CVString cv) {
    return 0.0;
  }

  @Override
  public CellValue apply(List<CellValue> vals) {
    Double outpt = 0.0;
    for (CellValue v: vals) {
      try {
        outpt += v.accept(this);
      } catch (IllegalStateException e) {
        return new CVError();
      }
    }
    return new CVDouble(outpt);
  }
}
