package edu.cs3500.spreadsheets.model;

public interface FormulaVisitor<R> {

  public R visitFunction();

  public R visitValue();

  public R visitRef();

}