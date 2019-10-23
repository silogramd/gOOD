package edu.cs3500.spreadsheets.model;

public class BoolCell implements Cell<Boolean> {

  Boolean contents;
  String rawInput;

  public BoolCell(String rawInput) {
    this.rawInput = rawInput;
    if (this.rawInput == "true") {
      this.contents = true;
    } else if (this.rawInput == "false") {
      this.contents = false;
    } else {
      throw new IllegalArgumentException("Wrong Cell Type: Contents is not a bool.");
    }
  }

  @Override
  public Boolean evaluate() {
    return this.contents;
  }

  @Override
  public String stringValue() {
    return Boolean.toString(this.contents);
  }

  @Override
  public String rawValue() {
    return this.rawInput;
  }
}
