package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class Function implements Formula {
  final Operation operation;
  private ArrayList<Formula> rest;

  public Function(Operation o, ArrayList<Formula> rest) {
    this.operation = o;
    this.rest = rest;
  }

  private ArrayList<CellValue> flatten() {
    ArrayList<CellValue> values = new ArrayList<>();
    for (Formula f: this.rest) {
      f.flattenHelp(values);
    }
    return values;
  }

  private CellValue calculate(ArrayList<CellValue> cells) {
    CellValue outpt = cells.remove(0);
    for (CellValue cv: cells) {
      outpt = cv.combine(outpt,this.operation);
    }
    return outpt;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(getValue());

  }

  @Override
  public void checkCycles(ArrayList<Coord> visited) {
    for (Formula f: this.rest) {
      f.checkCycles(visited);
    }
  }

  @Override
  public void accept(CycleVisitor cv) {
    cv.visitFunction(this.rest);
  }


  @Override
  public CellValue getValue() {
    return this.calculate(this.flatten());
  }

  @Override
  public String toString() {
    return getValue().toString();
  }
}
