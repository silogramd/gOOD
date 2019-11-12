package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.WorkSheetBuilderImpl;
import edu.cs3500.spreadsheets.model.WorksheetReader;
import edu.cs3500.spreadsheets.view.SpreadsheetFrameView;
import edu.cs3500.spreadsheets.view.SpreadsheetTextualView;
import edu.cs3500.spreadsheets.view.SpreadsheetView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
    }


    switch(args[0]) {
      case "-in":
        switch(args[2]) {
          case "-eval":
            evalHelp(args[1], args[3]);
            break;
          case "-save":
            saveHelp(args[1], args[3]);
            break;
          case "-gui":
            guiHelp(args[1]);
            break;
          default:
            throw new IllegalArgumentException("invalid syntax");
        }
        break;
      case "-gui":
        guiHelp("");
        break;
      default:
        throw new IllegalArgumentException("invalid syntax");
    }
  }


  private static void guiHelp(String fileName) {
    BasicSpreadsheetModel model;

    try {
      model = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader(fileName));
    } catch (FileNotFoundException ex) {
      model = new BasicSpreadsheetModel();
    }

    SpreadsheetView<Cell> gui = new SpreadsheetFrameView(model);
    try {
      gui.render();
    } catch (IOException ex) {
      throw new IllegalStateException("it broke");
    }
  }

  private static void saveHelp(String fileName, String newFileName) {
    BasicSpreadsheetModel model;

    try {
      model = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader(fileName));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }


    PrintWriter pw;
    File file = new File(newFileName);
    try {
      file.createNewFile();
      pw = new PrintWriter(new FileOutputStream(file,true));
    } catch (Exception ex) {
      throw new IllegalStateException("Cant open or make file");
    }

    SpreadsheetView<Cell> textView = new SpreadsheetTextualView(pw, model);

    try {
      textView.render();
    } catch (IOException ex) {
      throw new IllegalStateException("IOException");
    }

    pw.close();
  }


  private static void evalHelp(String fileName, String cell) {

    BasicSpreadsheetModel model;

    try {
      model = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader(fileName));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }
    String rawCellVal = model.getCellAt(new Coord(cell)).toString();
    if (rawCellVal.equals("")) {
      System.out.print("Error in Cell " + cell + ": Cell is empty");
    } else if (rawCellVal.equals("#ERROR")) {
      System.out.print("Error in Cell " + cell + ": Invalid raw contents.");
    } else {
      System.out.print(rawCellVal);
    }
  }
}
