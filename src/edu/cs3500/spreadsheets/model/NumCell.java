package edu.cs3500.spreadsheets.model;

public class NumCell implements Cell<Double> {

  private double contents;

  private String rawInput;

  public NumCell(String rawInput) {
    this.rawInput = rawInput;
    try {
      this.contents = Double.valueOf(this.rawInput);
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("Wrong Cell Type: Contents is not a double.");
    }
  }

  @Override
  public Double evaluate() {
    return this.contents;
  }

  @Override
  public String stringValue() {
    return Double.toString(this.contents);
  }

  @Override
  public String rawValue() {
    return this.rawInput;
  }
}
