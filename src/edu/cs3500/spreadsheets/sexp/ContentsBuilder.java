package edu.cs3500.spreadsheets.sexp;

import edu.cs3500.spreadsheets.model.AddObject;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CompareObject;
import edu.cs3500.spreadsheets.model.ConcatObject;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Formula;
import edu.cs3500.spreadsheets.model.FormulaValue;
import edu.cs3500.spreadsheets.model.Function;
import edu.cs3500.spreadsheets.model.ProductObject;
import edu.cs3500.spreadsheets.model.Reference;
import java.util.ArrayList;
import java.util.List;

public class ContentsBuilder implements SexpVisitor<Formula> {

  boolean isFormula = false;

  @Override
  public Formula visitBoolean(boolean b) {
    if (isFormula) {
      return new FormulaValue(new CVBool(b));
    }
    return new CVBool(b);
  }

  @Override
  public Formula visitNumber(double d) {
    if (isFormula) {
      return new FormulaValue(new CVDouble(d));
    }
    return new CVDouble(d);
  }

  @Override
  public Formula visitSList(List<Sexp> l) {
    return parseList(l);
    //TODO: FIGURE OUT WHAT TO DO HERE
  }

  private Formula parseList(List<Sexp> l) {
    ArrayList<Formula> forms = new ArrayList<>();
    this.isFormula = true;
    String symbol = l.remove(0).toString();
    for (Sexp s: l) {
      Formula f = s.accept(this);
      forms.add(f);
    }
    switch (symbol) {
      case "SUM":
        return new Function(new AddObject(), forms);
      case "<":
        return new Function(new CompareObject(), forms);
      case "PRODUCT":
        return new Function(new ProductObject(), forms);
      case "CONCAT":
        return new Function(new ConcatObject(), forms);
      default:
        throw new IllegalArgumentException("Not Valid Function.");
    }
  }

  @Override
  public Formula visitSymbol(String s) {
    checkValidReference(s);

    if (!s.contains(":")) {
      return new Reference(getCoord(s));
    } else {
      int colonIndex = s.indexOf(":");
      return new Reference(getCoord(s.substring(0,colonIndex)),
          getCoord(s.substring(colonIndex+1)));
    }
  }

  private void checkValidReference(String s) {
    int acc = 0;

    for(Character c : s.toCharArray()) {
      if(c.equals(':')) {
        acc += 1;
      }
    }

    if (acc > 1) {
      throw new IllegalArgumentException("not a valid reference");
    }
  }

  private Coord getCoord(String s) {
    StringBuilder sbNums = new StringBuilder();
    StringBuilder sbLetters = new StringBuilder();
    boolean seenDigit = false;

    for(Character c : s.toCharArray()) {
      if(Character.isDigit(c)) {
        seenDigit = true;
        sbNums.append(c);
      }
      if (seenDigit && Character.isAlphabetic(c)) {
        throw new IllegalArgumentException("Malformed input.");
      }
      sbLetters.append(c);
    }

    return new Coord(Coord.colNameToIndex(sbLetters.toString()),
        Integer.valueOf(sbNums.toString()));
  }

  @Override
  public Formula visitString(String s) {
    if (isFormula) {
      return new FormulaValue(new CVString(s));
    }
    return new CVString(s);
  }

}
