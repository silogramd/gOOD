import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Cell;
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
import java.util.Map;
import org.junit.Test;

public class SpreadsheetTextualViewTest {

  @Test
  public void testFileIO() {

    // make a model from a file
    BasicSpreadsheetModel model;
    try {
      model = WorksheetReader
          .read(new WorkSheetBuilderImpl(), new FileReader("resources/input1.txt"));
    } catch (FileNotFoundException ex) {
      throw new IllegalStateException("file not found");
    }

    //initialize a print writer to append to, and one to clear the file
    PrintWriter pw;
    PrintWriter clear;
    File file = new File("resources/input1-test.txt");

    try {
      file.createNewFile();
      pw = new PrintWriter(new FileOutputStream(file.getAbsoluteFile(),true));
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
    SpreadsheetView<Cell> textView = new SpreadsheetTextualView(pw, model);

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
    Map<Coord, Cell> map1 = model.getAllCells();
    Map<Coord, Cell> map2 = model2.getAllCells();

    for (Map.Entry<Coord,Cell> entry : map1.entrySet()) {
      assertTrue(map2.containsKey(entry.getKey()));
      assertEquals(map2.get(entry.getKey()), entry.getValue());
    }

    for (Map.Entry<Coord,Cell> entry : map2.entrySet()) {
      assertTrue(map1.containsKey(entry.getKey()));
      assertEquals(map1.get(entry.getKey()), entry.getValue());
    }

  }
}