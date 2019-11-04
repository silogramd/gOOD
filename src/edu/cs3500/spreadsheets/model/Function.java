package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

/**
 * <p>Class representing a Cell with a Function.</p>
 */
public class Function implements Formula {
  final Operation operation;
  private ArrayList<Formula> rest;

  /**
   * Default constructor.
   *
   * @param o the operation.
   * @param rest the items for the operation.
   */
  public Function(Operation o, ArrayList<Formula> rest) {
    this.operation = o;
    this.rest = rest;
  }


  /**
   * Flattens the {@link this.rest} list to CellValues.
   * @return the flattened list of CellValues.
   */
  private ArrayList<CellValue> flatten() {
    ArrayList<CellValue> values = new ArrayList<>();
    for (Formula f: this.rest) {
      f.flattenHelp(values);
    }
    return values;
  }

  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    acc.add(getValue());

  }

  @Override
  public CellValue getValue() {
    return this.operation.apply(flatten());
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
