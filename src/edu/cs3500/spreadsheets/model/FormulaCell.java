package edu.cs3500.spreadsheets.model;


public abstract class FormulaCell<R> implements Cell<R> {
  protected Cell[] cells;

  protected String rawInput;

  FormulaCell(Cell... args) {
    this.cells = args;
  }

  public abstract R apply();

  @Override
  public R evaluate() {

    return this.apply();
  }

  @Override
  public String rawValue() {
    return this.rawInput;
  }

  @Override
  public String stringValue() {
    return String.valueOf(this.evaluate());
  }

}
