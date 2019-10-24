package edu.cs3500.spreadsheets.model;

public interface Operation {

  <R> R apply(Function f);

  <R> R apply(FormulaValue v);

  <R> R apply(Reference r);



}
