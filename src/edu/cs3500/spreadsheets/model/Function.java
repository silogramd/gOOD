package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class Function implements Formula {
  //TODO: DO YOU EVEN NEED OPERATIONS? WHAT ARE THEY SUPPOSED TO DO?
  Operation operation;

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
    System.out.println("result of flatten: " + values.toString());
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
  public CellValue getValue() {
    //TODO: FIGURE THIS OUT
    //This should traverse through the list of Formulas, flatten the list down to just CellValues,
    //and then apply the function to all the CellValues. THE VISITOR PATTERN SHOULD BE USED HERE.
    return this.calculate(this.flatten());
    //return this.calculate(this.flatten());
  }

  @Override
  public CellValue accept(FormulaVisitor fv) {
    //THIS IS PART OF AFOREMENTIONED VISITOR PATTERN.
    return null;
  }

  @Override
  public String toString() {
    return getValue().toString();
  }
}
