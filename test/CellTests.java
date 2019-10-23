import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import edu.cs3500.spreadsheets.model.AddCell;
import edu.cs3500.spreadsheets.model.BoolCell;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.NumCell;
import org.junit.Test;

public class CellTests {

  @Test
  public void testConstructors() {
    Cell num1 = new NumCell("13.4");
    assertEquals(num1.evaluate(), 13.4);
    assertEquals(num1.rawValue(), "13.4");
    assertEquals(num1.stringValue(), "13.4");
    Cell bool1 = new BoolCell("false");
    assertEquals(bool1.evaluate(), false);
    assertEquals(bool1.rawValue(), "false");
    assertEquals(bool1.stringValue(), "false");

    AddCell add1 = new AddCell(num1, num1);
    assertEquals(add1.evaluate(), 26.8);

  }

}
