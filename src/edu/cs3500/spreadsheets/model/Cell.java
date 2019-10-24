package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.ContentsBuilder;
import edu.cs3500.spreadsheets.sexp.Parser;

public class Cell implements ICell {

  private String rawContents;
  private Coord coord;
  private CellContents contents;


  Cell(int row, int col, String contents) {
    this.rawContents = contents;
    this.coord = new Coord(row,col);
    Parser p = new Parser();
    this.contents = p.parse(this.rawContents).accept(new ContentsBuilder());
  }

  @Override
  public CellValue getValue() {
    return contents.getValue();
  }

  @Override
  public String getRawValue() {
    return rawContents;
  }

  @Override
  public Coord getCoord() {
    return new Coord(this.coord.col, this.coord.row);
  }

}
