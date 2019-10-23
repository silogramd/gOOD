package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class Function implements Formula {

  private Operation operation;

  private ArrayList<Formula> rest;

  Function(Operation o, ArrayList<Formula> rest) {
    this.operation = o;
    this.rest = rest;
  }

  @Override
  public CellValue getValue() {
    //TODO: FIGURE THIS OUT
    //This should traverse through the list of Formulas, flatten the list down to just CellValues,
    //and then apply the function to all the CellValues. THE VISITOR PATTERN SHOULD BE USED HERE.
    return null;
  }

  @Override
  public CellValue accept(FormulaVisitor fv) {
    //THIS IS PART OF AFOREMENTIONED VISITOR PATTERN.
    return null;
  }
}
