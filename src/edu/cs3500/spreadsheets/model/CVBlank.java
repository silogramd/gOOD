package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CVBlank extends CellValue {


  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    //do nothing! if value is blank, there is nothing to flatten.
  }

  @Override
  public void accept(CycleVisitor cv) {
    //do nothing! Cycles are only relevant for References and Formulas.
  }

  @Override
  public String toString() {
    return "";
  }

}
