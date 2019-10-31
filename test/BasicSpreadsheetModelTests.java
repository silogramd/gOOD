import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import edu.cs3500.spreadsheets.model.BasicSpreadsheetModel;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.ICell;
import edu.cs3500.spreadsheets.model.SpreadsheetModel;
import java.util.HashMap;
import org.junit.Test;

public class BasicSpreadsheetModelTests {


  @Test
  public void testEmptySheet() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    assertEquals(new HashMap<Coord, ICell>(), m.getAllCells());
  }

  @Test
  public void getCell() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.editCell(new Coord(1,1), "2");
    assertEquals(m.getCellAt(new Coord(1,1)).toString(), String.format("%f", 2.0));
    assertEquals(m.getCellAt(new Coord(7,7)).toString(), "");
    m.clearSheet();
  }

  @Test
  public void testAddCell() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.editCell(new Coord(1,1), "2");
    assertEquals(m.getCellAt(new Coord(1,1)).toString(), String.format("%f", 2.0));
    m.clearSheet();
  }

  @Test
  public void testEditCell() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.editCell(new Coord(1,1), "2");
    assertEquals(m.getCellAt(new Coord(1,1)).toString(), String.format("%f", 2.0));
    m.editCell(new Coord(1,1), "hi!");
    assertEquals(m.getCellAt(new Coord(1,1)).toString(), "hi!");
    m.clearSheet();
  }

  @Test
  public void testCellTypes() {
    SpreadsheetModel m = new BasicSpreadsheetModel();
    m.editCell(new Coord(1,1), "2");
    m.editCell(new Coord(1,2), "A1");
    m.editCell(new Coord(1,3), "=(< 1 2)");
    m.editCell(new Coord(1,4), "\"this is a string\"");
    m.editCell(new Coord(2,1), "=(SUM A1 A2)");
    m.editCell(new Coord(2,2), "=(PRODUCT 3 4)");
    m.editCell(new Coord(2,3), "=(CONCAT A4 \":)\")");
    m.editCell(new Coord(3,1), "=(SUM A1 A3)");
    m.editCell(new Coord(4,1), "=(SUM A1:A2)");
    assertEquals(m.getCellAt(new Coord(1,1)).toString(), String.format("%f", 2.0));
    assertEquals(m.getRawCellAt(new Coord(1,1)), "2");
    assertEquals(m.getCellAt(new Coord(1,2)).toString(), String.format("%f", 2.0));
    assertEquals(m.getRawCellAt(new Coord(1,2)), "A1");
    assertEquals(m.getCellAt(new Coord(1,3)).toString(), "true");
    assertEquals(m.getRawCellAt(new Coord(1,3)), "=(< 1 2)");
    assertEquals(m.getCellAt(new Coord(1,4)).toString(), "this is a string");
    assertEquals(m.getCellAt(new Coord(2,1)).toString(), String.format("%f", 4.0));
    assertEquals(m.getRawCellAt(new Coord(2,1)), "=(SUM A1 A2)");
    assertEquals(m.getCellAt(new Coord(2,2)).toString(), String.format("%f", 12.0));
    assertEquals(m.getRawCellAt(new Coord(2,2)), "=(PRODUCT 3 4)");
    assertEquals(m.getCellAt(new Coord(2,3)).toString(), "this is a string:)");
    assertEquals(m.getCellAt(new Coord(3,1)).toString(), "#ERROR");
    assertEquals(m.getCellAt(new Coord(4,1)).toString(), String.format("%f", 4.0));
    m.clearSheet();
  }

  @Test
  public void testNoCycles() {

  }
}
