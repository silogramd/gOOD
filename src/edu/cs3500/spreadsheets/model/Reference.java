package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Represents a reference cell value.
 */
public class Reference implements Formula {

  private final ArrayList<Coord> reference;
  private final BasicSpreadsheetModel model;
  private final String position;

  /**
   * Constructor for box references.
   *
   * @param first    The first corner.
   * @param last     The opposite corner.
   * @param position The position of this reference cell.
   * @throws IllegalArgumentException if there is a cycle.
   */
  public Reference(Coord first, Coord last, Coord position, BasicSpreadsheetModel model) {
    this.reference = new ArrayList<>();
    this.position = position.toString();

    int width = Math.abs(last.col - first.col);
    int height = Math.abs(last.row - first.row);
    int colStart = Math.min(last.col, first.col);
    int rowStart = Math.min(last.row, first.row);
    int colEnd = width + colStart;
    int rowEnd = height + rowStart;
    this.model = model;
    for (int i = colStart; i <= colEnd; i++) {
      for (int j = rowStart; j <= rowEnd; j++) {
        Coord coord = new Coord(i, j);
        if (noCycles(coord)) {
          reference.add(coord);
        } else {
          throw new IllegalArgumentException("there is a cycle");
        }
      }
    }

  }

  /**
   * Constructor for a single cell reference.
   *
   * @param c        the cell to reference.
   * @param position of this cell.
   * @throws IllegalArgumentException if there is a cycle
   */
  public Reference(Coord c, Coord position, BasicSpreadsheetModel model) {
    this.position = position.toString();
    this.model = model;
    if (noCycles(c)) {
      this.reference = new ArrayList<>();
      reference.add(c);
    } else {
      throw new IllegalArgumentException("there is a cycle");
    }
  }

  @Override
  public CellValue getValue() {
    if (reference.size() == 1) {
      return model.coordMap
          .getOrDefault(reference.get(0), new Cell(new Coord(1, 1))).getValue();
    } else {
      return new CVError();
    }
  }


  @Override
  public void flattenHelp(ArrayList<CellValue> acc) {
    for (Coord c : this.reference) {
      if (model.coordMap.containsKey(c)) {
        acc.add(model.getCellAt(c).getValue());
      }
    }
  }

  @Override
  public boolean hasCycle() {
    Stack<Formula> worklist = new Stack<>();
    ArrayList<Formula> seen = new ArrayList<>();
    addAllRefs(worklist);
    while (!worklist.isEmpty()) {
      Formula next = worklist.pop();
      if (seen.contains(next)) {
        if (!next.isFlat()) {
          return true;
        }
      } else {
        for (Formula f : next.getEdges()) {
          worklist.add(f);
        }
        seen.add(next);
      }
    }
    return false;
  }

  @Override
  public boolean isFlat() {
    if (reference.size() == 1) {
      return model.getCellAt(reference.get(0)).getContents().isFlat();
    }
    return false;
  }

  private void addAllRefs(Collection<Formula> collection) {
    for (Coord c : this.reference) {
      collection.add(model.getCellAt(c).getContents());
    }
  }

  @Override
  public Set<Formula> getEdges() {
    Set<Formula> set = new HashSet<>();
    addAllRefs(set);
    return set;
  }

  private boolean noCycles(Coord coord) {
    String otherRaw = model.coordMap.getOrDefault(coord, new Cell(coord)).getRawValue();
    if (otherRaw.length() > 1) {
      if ((otherRaw.charAt(0) == '=') && (otherRaw.contains(position))) {
        return false;
      }
    }
    return true;
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

    if (!(other instanceof Reference)) {
      return false;
    }

    Reference o = (Reference) other;

    boolean refSame = true;
    if (reference.size() == o.reference.size()) {
      ArrayList<Coord> copy = new ArrayList<>();
      copy.addAll(o.reference);
      for (Coord c : reference) {
        if (copy.contains(c)) {
          copy.remove(c);
        } else {
          refSame = false;
        }
      }
    }

    return this.position.equals(o.position) && refSame;
  }

  @Override
  public int hashCode() {
    return reference.hashCode() * position.hashCode() * 31;
  }
}
