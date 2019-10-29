package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVString extends CellValue {

  final String contents;

  public CVString(String s) {
    this.contents = s;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(this);
  }

  @Override
  public void checkCycles(ArrayList<Coord> visited) {

  }

  @Override
  public void accept(CycleVisitor cv) {
    //do nothing! Cycles are only relevant for References and Formulas.
  }

  @Override
  public String toString() {
    return this.contents;
  }
}
