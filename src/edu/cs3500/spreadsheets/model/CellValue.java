package edu.cs3500.spreadsheets.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Interface for CellContents that are solely values.
 */
public abstract class CellValue implements Formula {

  public abstract <R> R accept(CellValueVisitor<R> visitor);

  @Override
  public CellValue getValue() {
    return this;
  }

  @Override
  public boolean isFlat() {
    return true;
  }

  @Override
  public boolean hasCycle() {
    return false;
  }

  @Override
  public Set<Formula> getEdges() {
    return new HashSet<Formula>();
  }

}
