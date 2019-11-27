import static org.junit.Assert.assertEquals;

import edu.cs3500.spreadsheets.controller.SpreadSheetController;
import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.view.SpreadsheetTextualView;
import java.io.IOException;
import org.junit.Test;

/**
 * Test class for the controller.
 */
public class SpreadSheetControllerTest {

  /**
   * Ensure start renders the view.
   */
  @Test
  public void start() throws IOException {
    StringBuilder sb = new StringBuilder();
    BasicSpreadsheetModel model = new BasicSpreadsheetModel();
    SpreadsheetTextualView view = new SpreadsheetTextualView(sb, model);
    SpreadSheetController controller = new SpreadSheetController(model, view);
    // check default is correct.
    assertEquals("", sb.toString());
    model.editCell(new Coord(1, 1), "1");

    controller.start();
    // ensure render happened.
    assertEquals("A1 1\n", sb.toString());

  }

  /**
   * Tests that changing the editable coord works.
   */
  @Test
  public void setEditableCoord() {
    StringBuilder sb = new StringBuilder();
    BasicSpreadsheetModel model = new BasicSpreadsheetModel();
    SpreadsheetTextualView view = new SpreadsheetTextualView(sb, model);
    SpreadSheetController controller = new SpreadSheetController(model, view);

    // check default is correct.
    model.editCell(new Coord(1, 1), "1");
    model.editCell(new Coord(2, 2), "2");
    assertEquals(controller.getEditableCell().getRawValue(), "1");

    // ensure correct change is made.
    controller.setEditableCoord(new Coord(2, 2));
    assertEquals(controller.getEditableCell().getRawValue(), "2");
  }

  /**
   * Test to ensure get editable cell gets the correct cell.
   */
  @Test
  public void getEditableCell() {
    StringBuilder sb = new StringBuilder();
    BasicSpreadsheetModel model = new BasicSpreadsheetModel();
    SpreadsheetTextualView view = new SpreadsheetTextualView(sb, model);
    SpreadSheetController controller = new SpreadSheetController(model, view);

    Cell cell1 = new Cell(1, 1, "1", model);
    Cell cell2 = new Cell(new Coord(2, 2));

    // default start editable cell is at coord 1,1
    model.editCell(new Coord(1, 1), "1");
    assertEquals(controller.getEditableCell(), cell1);

    controller.setEditableCoord(new Coord(2, 2));
    assertEquals(controller.getEditableCell(), cell2);
  }

  /**
   * Ensure cell values in the model are changed.
   */
  @Test
  public void confirmEdits() {
    StringBuilder sb = new StringBuilder();
    BasicSpreadsheetModel model = new BasicSpreadsheetModel();
    SpreadsheetTextualView view = new SpreadsheetTextualView(sb, model);
    SpreadSheetController controller = new SpreadSheetController(model, view);

    controller.confirmEdits("dog");
    assertEquals(model.getRawCellAt(new Coord(1,1)), "dog");

    Coord B2 = new Coord(2,2);
    controller.setEditableCoord(B2);
    controller.confirmEdits("1");
    assertEquals(model.getRawCellAt(B2), "1");
    controller.confirmEdits("2");
    assertEquals(model.getRawCellAt(B2), "2");
  }
}