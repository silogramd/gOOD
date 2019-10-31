import edu.cs3500.spreadsheets.model.AddObject;
import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.CellValue;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Operation;
import edu.cs3500.spreadsheets.model.Reference;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class CellTest {

  Cell c1 = new Cell(1,1, "dog");
  Cell c2 = new Cell(new Coord(1, 1), "1");
  Cell c3 = new Cell(new Coord(1, 1));
  Cell c4 = new Cell(new Coord(1,1),"true");
  Cell c5 = new Cell(new Coord(1,1),"=A2");
  Cell c6 = new Cell(new Coord(1,1), "=(SUM A2 A3)");

  @Test
  public void getValue() {
    assertEquals(c1.getValue(), new CVString("dog"));
    assertEquals(c2.getValue(), new CVDouble(1));
    assertEquals(c3.getValue(), new CVBlank());
    assertEquals(c4.getValue(), new CVBool(true));
  }

  @Test
  public void getRawValue() {
    assertEquals(c1.getRawValue(), "dog");
    assertEquals(c2.getRawValue(), "1");
    assertEquals(c3.getRawValue(), "");
    assertEquals(c5.getRawValue(), "=A2");
    assertEquals(c6.getRawValue(), "=(SUM A2 A3)");
  }

  @Test
  public void getCoord() {
    assertEquals(c1.getCoord(), new Coord(1,1));
    assertEquals(c2.getCoord(), new Coord(1,1));
    assertEquals(c3.getCoord(), new Coord(1,1));
  }

  @Test
  public void testToString() {
    assertEquals(c1.toString(), "dog");
    assertEquals(c2.toString(), "1.000000");
    assertEquals(c3.toString(), "");
  }
}