package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.WorkSheetBuilderImpl;
import edu.cs3500.spreadsheets.model.WorksheetReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * The main class for our program.
 */
public class BeyondGood {
  /**
   * The main entry point.
   * @param args any command-line arguments
   */
  public static void main(String[] args) {
    /*
      TODO: For now, look in the args array to obtain a filename and a cell name,
      - read the file and build a model from it, 
      - evaluate all the cells, and
      - report any errors, or print the evaluated value of the requested cell.
    */
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
      System.out.print("Error in Cell " + args[3] + ": Cell is empty");
    } else if (rawCellVal.equals("#ERROR")) {
      System.out.print("Error in Cell " + args[3] + ": Invalid raw contents.");
    } else {
      System.out.print(rawCellVal);
    }
  }
}
