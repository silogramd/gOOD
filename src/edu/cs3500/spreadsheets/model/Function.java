package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Function implements Formula {
  final Operation operation;
  private ArrayList<Formula> rest;
  private CellValue evaluated;

  public Function(Operation o, ArrayList<Formula> rest) {
    this.operation = o;
    this.rest = rest;
    this.evaluated = this.calculate(this.flatten());
  }

  void refresh() {
    this.evaluated = this.calculate(this.flatten());
  }


  private ArrayList<CellValue> flatten() {
    ArrayList<CellValue> values = new ArrayList<>();
    for (Formula f: this.rest) {
      f.flattenHelp(values);
    }
    return values;
  }

  private CellValue calculate(ArrayList<CellValue> cells) {
    System.out.println(cells);
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
  public CellValue getValue() {
    return this.evaluated;
  }

  @Override
  public String toString() {
    return getValue().toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof Function)) {
      return false;
    }

    Function o = (Function)other;

    boolean restSame = true;
    if (rest.size() == o.rest.size()) {
      ArrayList<Formula> copy = new ArrayList<>();
      copy.addAll(o.rest);
      for (Formula f : rest) {
        if (copy.contains(f)) {
          copy.remove(f);
        } else {
          restSame = false;
        }
      }
    }

    return o.operation.equals(operation) && restSame;
  }

  @Override
  public int hashCode() {
    return operation.hashCode() * 31 * rest.hashCode();
  }
}
