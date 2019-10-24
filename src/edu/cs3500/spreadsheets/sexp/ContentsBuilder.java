package edu.cs3500.spreadsheets.sexp;

import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CellContents;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVString;
import java.util.List;
import java.util.Stack;

public class ContentsBuilder implements SexpVisitor<CellContents> {

  @Override
  public CellContents visitBoolean(boolean b) {
    return new CVBool(b);
  }

  @Override
  public CellContents visitNumber(double d) {
    return new CVDouble(d);
  }

  @Override
  public CellContents visitSList(List<Sexp> l) {

  }

  @Override
  public CellContents visitSymbol(String s) {
    return new CVString(s);
  }

  @Override
  public CellContents visitString(String s) {
    return new CVString(s);
  }

}
