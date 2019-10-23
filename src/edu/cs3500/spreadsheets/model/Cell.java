package edu.cs3500.spreadsheets.model;

public interface Cell<R> {

  public R evaluate();

  public String stringValue();

  public  String rawValue();

}
