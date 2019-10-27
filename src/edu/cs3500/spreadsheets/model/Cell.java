package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.ContentsBuilder;
import edu.cs3500.spreadsheets.sexp.Parser;

public class Cell implements ICell {

  private String rawContents;
  private Coord coord;
  private Formula contents;


  Cell(int row, int col, String contents) {
    this.rawContents = contents;
    this.coord = new Coord(col,row);
    this.contents = createContents(contents);
  }

  Cell(Coord coord, String contents) {
    this.rawContents = contents;
    this.coord = coord;
    this.contents = createContents(contents);
  }

  Cell(Coord coord) {
    this.contents = new CVBlank();
    this.rawContents = "";
    this.coord = coord;
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


  // for debugging
  @Override
  public String toString() {
    return "Cell contents = " + this.getValue().toString() + "\n";
  }


  private Formula createContents(String contents) {
    Parser p = new Parser();

    if (contents.charAt(0) == '=') {
      return p.parse(this.rawContents.substring(1)).accept(new ContentsBuilder());
    } else {
      return p.parse(this.rawContents).accept(new ContentsBuilder());
    }
  }

}
