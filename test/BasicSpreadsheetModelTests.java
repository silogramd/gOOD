import static org.junit.Assert.assertEquals;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ICell;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.util.HashMap;
import org.junit.Test;

/**
 * <p>Class representing tests for a BasicSpreadSheetModel.</p>
 */
public class BasicSpreadsheetModelTests {


  @Test
  public void testEmptySheet() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    assertEquals(new HashMap<Coord, ICell>(), m.getAllCells());
  }

  @Test
  public void getCell() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.clearSheet();
    m.editCell(new Coord(1, 1), "2");
    assertEquals(m.getCellAt(new Coord(1, 1)).toString(), String.format("%f", 2.0));
    assertEquals(m.getCellAt(new Coord(7, 7)).toString(), "");
    m.clearSheet();
  }

  @Test
  public void testAddCell() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.editCell(new Coord(1, 1), "2");
    assertEquals(m.getCellAt(new Coord(1, 1)).toString(), String.format("%f", 2.0));
    m.clearSheet();
  }

  @Test
  public void testEditCell() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.editCell(new Coord(1, 1), "2");
    assertEquals(m.getCellAt(new Coord(1, 1)).toString(), String.format("%f", 2.0));
    m.editCell(new Coord(1, 1), "hi!");
    assertEquals(m.getCellAt(new Coord(1, 1)).toString(), "hi!");
    m.clearSheet();
    m.editCell(new Coord(2, 1), "4");
    m.editCell(new Coord(2, 2), "=(SUM B1 B1)");
    assertEquals(m.getCellAt(new Coord(2, 2)).toString(), String.format("%f", 8.0));
    m.editCell(new Coord(2, 1), "1");
    assertEquals(m.getCellAt(new Coord(2, 2)).toString(), String.format("%f", 2.0));
    m.clearSheet();
  }

  @Test
  public void testCellTypes() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.editCell(new Coord(1, 1), "2");
    m.editCell(new Coord(1, 2), "A1");
    m.editCell(new Coord(1, 3), "=(< 1 2)");
    m.editCell(new Coord(1, 4), "\"this is a string\"");
    m.editCell(new Coord(2, 1), "=(SUM A1 A2)");
    m.editCell(new Coord(2, 2), "=(PRODUCT 3 4)");
    m.editCell(new Coord(2, 3), "=(CONCAT A4 \":)\")");
    m.editCell(new Coord(3, 1), "=(SUM A1 A3)");
    m.editCell(new Coord(4, 1), "=(SUM A1:A2)");
    assertEquals(m.getCellAt(new Coord(1, 1)).toString(), String.format("%f", 2.0));
    assertEquals(m.getRawCellAt(new Coord(1, 1)), "2");
    assertEquals(m.getCellAt(new Coord(1, 2)).toString(), String.format("%f", 2.0));
    assertEquals(m.getRawCellAt(new Coord(1, 2)), "A1");
    assertEquals(m.getCellAt(new Coord(1, 3)).toString(), "true");
    assertEquals(m.getRawCellAt(new Coord(1, 3)), "=(< 1 2)");
    assertEquals(m.getCellAt(new Coord(1, 4)).toString(), "this is a string");
    assertEquals(m.getCellAt(new Coord(2, 1)).toString(), String.format("%f", 4.0));
    assertEquals(m.getRawCellAt(new Coord(2, 1)), "=(SUM A1 A2)");
    assertEquals(m.getCellAt(new Coord(2, 2)).toString(), String.format("%f", 12.0));
    assertEquals(m.getRawCellAt(new Coord(2, 2)), "=(PRODUCT 3 4)");
    assertEquals(m.getCellAt(new Coord(2, 3)).toString(), "this is a string:)");
    assertEquals(m.getCellAt(new Coord(3, 1)).toString(), String.format("%f", 2.0));
    assertEquals(m.getCellAt(new Coord(4, 1)).toString(), String.format("%f", 4.0));
    m.clearSheet();

    m.editCell(new Coord(3, 3), "4");
    m.editCell(new Coord(3, 4), "=(SUM C3 C3)");
    assertEquals(m.getCellAt(new Coord(3, 4)).getValue(), new CVDouble(8));

    m.editCell(new Coord(3, 5), "=(SUM C3 TRUE)");
    assertEquals(m.getCellAt(new Coord(3, 5)).getValue(), new CVDouble(4));
  }

  @Test
  public void testNoCycles() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.editCell(new Coord(1, 1), "=A2");
    m.editCell(new Coord(1, 2), "=A1");
    assertEquals(m.getCellAt(new Coord(1, 2)).toString(), "#ERROR");

    m.editCell(new Coord(2, 1), "=B1");
    assertEquals(m.getCellAt(new Coord(2, 1)).toString(), "#ERROR");

    m.editCell(new Coord(1, 3), "4");
    m.editCell(new Coord(1, 4), "=A5");
    m.editCell(new Coord(1, 5), "=(SUM A3:A4)");
    assertEquals(m.getCellAt(new Coord(1, 5)).toString(), "#ERROR");
    assertEquals(m.getCellAt(new Coord(1, 4)).toString(), "#ERROR");
    m.clearSheet();

  }
}
