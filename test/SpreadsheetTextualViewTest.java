import static org.junit.Assert.assertEquals;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Coord;
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
import org.junit.Test;

public class SpreadsheetTextualViewTest {

  @Test
  public void testFileIO() {
    BasicSpreadsheetModel model;

    try {
      model = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader("input1.txt"));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }


    PrintWriter pw;
    PrintWriter clear;
    try {
      pw = new PrintWriter(new FileOutputStream(new File("input1.txt"),true));
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }

    try {
      clear = new PrintWriter("input1.txt");
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }
    clear.print("");
    clear.close();

    SpreadsheetView textView = new SpreadsheetTextualView(pw, model);

    try {
      textView.render();
    } catch (IOException ex) {
      throw new IllegalStateException("IOException");
    }


    pw.close();

    BasicSpreadsheetModel model2;

    try {
      model2 = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader("input1.txt"));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }

    assertEquals(model.getCellAt(new Coord(1,1)),
        model2.getCellAt(new Coord(1,1)));
    assertEquals(model.getCellAt(new Coord(1,2)),
        model2.getCellAt(new Coord(1,2)));
    assertEquals(model.getCellAt(new Coord(1,3)),
        model2.getCellAt(new Coord(1,3)));
    assertEquals(model.getCellAt(new Coord(1,4)),
        model2.getCellAt(new Coord(1,4)));
    assertEquals(model.getCellAt(new Coord(2,1)),
        model2.getCellAt(new Coord(2,1)));
    assertEquals(model.getCellAt(new Coord(2,2)),
        model2.getCellAt(new Coord(2,2)));
    assertEquals(model.getCellAt(new Coord(2,3)),
        model2.getCellAt(new Coord(2,3)));
    assertEquals(model.getCellAt(new Coord(2,4)),
        model2.getCellAt(new Coord(2,4)));


  }
}