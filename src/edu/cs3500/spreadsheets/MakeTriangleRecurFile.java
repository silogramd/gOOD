package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.WorkSheetBuilderImpl;
import edu.cs3500.spreadsheets.model.WorksheetReader;
import edu.cs3500.spreadsheets.view.SpreadsheetTextualView;
import edu.cs3500.spreadsheets.view.SpreadsheetView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MakeTriangleRecurFile {

  public static void main(String[] args) {

    File file = new File("resources/triangleinput.txt");

    PrintWriter clear;
    try {
      clear = new PrintWriter(file.getAbsoluteFile());
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }
    //clear the file
    clear.print("");
    clear.close();

    PrintWriter pw;

    try {
      file.createNewFile();
      pw = new PrintWriter(new FileOutputStream(file, true));
    } catch (Exception ex) {
      throw new IllegalStateException("Cant open or make file");
    }

    pw.append("A1 1\n");

    for (int i = 2; i <= 50; i++) {
      String toAppend = "A";

      toAppend += i;
      toAppend += " =(SUM A";
      toAppend += (i - 1);
      toAppend += " ";
      toAppend += i;
      toAppend += ")\n";

      pw.append(toAppend);

    }

    pw.close();
  }
}

