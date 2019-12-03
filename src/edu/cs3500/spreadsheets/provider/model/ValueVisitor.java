package edu.cs3500.spreadsheets.provider.model;

public interface ValueVisitor<R> {

  /**
   * returns double as a string.
   *
   * @param d the double value
   */
  String visitValueDouble(Double d);

  /**
   * returns boolean as a string.
   *
   * @param b the boolean value
   */
  String visitValueBoolean(Boolean b);

  /**
   * returns string.
   *
   * @param s the string value
   */
  String visitValueString(String s);

  /**
   * returns blank value as a string.
   */
  String visitBlankValue();

  /**
   * returns error as a string.
   *
   * @param e the error value
   */
  String visitErr(IException e);
}

