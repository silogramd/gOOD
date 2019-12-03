import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ICell;
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
import java.util.Map;
import org.junit.Test;

/**
 * Class with test cases for the spreadsheet textual view.
 */
public class SpreadsheetTextualViewTest {

  /**
   * Test via round trip testing.
   */
  @Test
  public void testFileIO() {

    // make a model from a file
    BasicSpreadsheetModel model1;
    try {
      model1 = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader("resources/input1.txt"));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }

    //initialize a print writer to append to, and one to clear the file
    PrintWriter pw;
    PrintWriter clear;
    File file = new File("resources/input1-textualview.txt");

    try {
      file.createNewFile();
      pw = new PrintWriter(new FileOutputStream(file.getAbsoluteFile(), true));
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }

    try {
      clear = new PrintWriter(file.getAbsoluteFile());
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }
    //clear the file
    clear.print("");
    clear.close();
    // create a new view using the cleared new file and old file model
    SpreadsheetView textView = new SpreadsheetTextualView(pw, model1);

    // save to the new file
    try {
      textView.render();
    } catch (IOException ex) {
      throw new IllegalStateException("IOException");
    }

    pw.close();

    // making a second model to rebuild based on the new file
    BasicSpreadsheetModel model2;
    try {
      model2 = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader(file.getAbsoluteFile()));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }

    // ensure the models are the same
    Map<Coord, ICell> map1 = model1.getAllCells();
    Map<Coord, ICell> map2 = model2.getAllCells();

    for (Map.Entry<Coord, ICell> entry : map1.entrySet()) {
      assertTrue(map2.containsKey(entry.getKey()));
      assertEquals(map2.get(entry.getKey()), entry.getValue());
    }

    for (Map.Entry<Coord, ICell> entry : map2.entrySet()) {
      assertTrue(map1.containsKey(entry.getKey()));
      assertEquals(map1.get(entry.getKey()), entry.getValue());
    }

  }

  /**
   * Creating other textual views for all input examples.
   */
  @Test
  public void createOtherTextViewFiles() {

    // make a model from input2
    BasicSpreadsheetModel model1;
    try {
      model1 = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader("resources/input2.txt"));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }

    //initialize a print writer to append to, and one to clear the file
    PrintWriter pw;
    PrintWriter clear;
    File file = new File("resources/input2-textualview.txt");

    try {
      file.createNewFile();
      pw = new PrintWriter(new FileOutputStream(file.getAbsoluteFile(), true));
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }

    try {
      clear = new PrintWriter(file.getAbsoluteFile());
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }
    //clear the file
    clear.print("");
    clear.close();
    // create a new view using the cleared new file and old file model
    SpreadsheetView textView = new SpreadsheetTextualView(pw, model1);

    // save to the new file
    try {
      textView.render();
    } catch (IOException ex) {
      throw new IllegalStateException("IOException");
    }

    pw.close();

    // make a model from a file
    BasicSpreadsheetModel model2;
    try {
      model2 = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader("resources/input3.txt"));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }

    //initialize a print writer to append to, and one to clear the file
    PrintWriter pw2;
    PrintWriter clear2;
    File file2 = new File("resources/input3-textualview.txt");

    try {
      file.createNewFile();
      pw2 = new PrintWriter(new FileOutputStream(file2.getAbsoluteFile(), true));
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }

    try {
      clear2 = new PrintWriter(file2.getAbsoluteFile());
    } catch (Exception ex) {
      throw new IllegalStateException("file not found");
    }
    //clear the file
    clear2.print("");
    clear2.close();
    // create a new view using the cleared new file and old file model
    SpreadsheetView textView2 = new SpreadsheetTextualView(pw2, model2);

    // save to the new file
    try {
      textView2.render();
    } catch (IOException ex) {
      throw new IllegalStateException("IOException");
    }

    pw2.close();

    assertNotEquals(model1, model2);
  }
}