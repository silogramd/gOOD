package edu.cs3500.spreadsheets.model;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class BeyondGood {

  public static void main(String[] args) {
    if (args.length > 4) {
      throw new IllegalArgumentException("too many args");
    } else if (!(args[0].equals("-in")) || !(args[2].equals("-eval"))) {
      throw new IllegalArgumentException("invalid syntax");
    }
    BasicSpreadsheetModel model;

    try {
      model = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader(args[1]));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }
    String rawCellVal = model.getCellAt(new Coord(args[3])).toString();
    if (rawCellVal.equals("")) {
      System.out.println("Error in Cell " + args[3] + ": Cell is empty");
    } else if (rawCellVal.equals("#ERROR")) {
      System.out.println("Error in Cell " + args[3] + ": Invalid raw contents.");
    } else {
      System.out.println(rawCellVal);
    }
  }

}
