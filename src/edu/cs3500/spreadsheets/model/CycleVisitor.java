package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;

public class CycleVisitor {

  ArrayList<Coord> visited;

  CycleVisitor(ArrayList<Coord> visited) {
    this.visited = visited;
  }

  public void visitFunction(ArrayList<Formula> f) throws IllegalStateException {
    for (Formula form: f) {
      //form.accept(this);
    }
  }

  public void visitReference(ArrayList<Coord> refs) throws IllegalStateException{
    for (Coord c: refs) {
      if (visited.contains(c)) {
        throw new IllegalStateException("Cyclic Reference found.");
      }
    }
  }

}
