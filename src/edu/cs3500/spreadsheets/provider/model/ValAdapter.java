package edu.cs3500.spreadsheets.provider.model;

import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CellValue;

public class ValAdapter implements IVal {

  private CellValue val;

  public ValAdapter() {
    this.val = new CVBlank();
  }

  public ValAdapter(CellValue val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return this.val.toString();
  }

  @Override
  public <R> R accept(ValueVisitor<R> evalInstructions)
      throws IllegalStateException, IllegalArgumentException {
    return (R) val.accept(new VisitorAdapter(evalInstructions));
  }
}
