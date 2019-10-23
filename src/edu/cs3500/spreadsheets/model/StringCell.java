package edu.cs3500.spreadsheets.model;

public class StringCell implements Cell<String> {

  String contents;
  String rawInput;

  StringCell(String rawInput) {
    this.rawInput = rawInput;
    this.contents = rawInput;
  }


  @Override
  public String evaluate() {
    return contents;
  }

  @Override
  public String stringValue() {
    return contents;
  }

  @Override
  public String rawValue() {
    return rawInput;
  }
}
