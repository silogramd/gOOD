import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CellValue;
import edu.cs3500.spreadsheets.model.CompareObject;
import edu.cs3500.spreadsheets.model.Operation;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * <p>Class representing CompareObject tests.</p>
 */
public class CompareObjectTest {

  @Test
  public void applyTest() {

    CellValue addObj1 = new CVDouble(1.0);
    CellValue addObj2 = new CVDouble(2.0);
    CellValue blankObj = new CVBlank();
    CellValue boolObj = new CVBool(false);
    CellValue errObj = new CVError();
    CellValue stringObj = new CVString("test");

    Operation compObj = new CompareObject();
    ArrayList<CellValue> cells = new ArrayList<>();

    cells.add(addObj1);
    cells.add(addObj2);
    assertFalse(compObj.apply(cells) instanceof CVError);
    cells.remove(addObj2);
    cells.add(blankObj);
    assertTrue(compObj.apply(cells) instanceof CVError);
    cells.remove(blankObj);
    cells.add(boolObj);
    assertTrue(compObj.apply(cells) instanceof CVError);
    cells.remove(boolObj);
    cells.add(stringObj);
    assertTrue(compObj.apply(cells) instanceof CVError);
    cells.remove(stringObj);
    cells.add(errObj);
    assertTrue(compObj.apply(cells) instanceof CVError);

    cells.clear();
    cells.add(addObj1);
    cells.add(addObj2);
    CellValue returned = compObj.apply(cells);
    assertTrue(returned instanceof CVBool);
    assertEquals(returned.toString(), "true");

    cells.clear();
    cells.add(addObj2);
    cells.add(addObj1);
    CellValue returned2 = compObj.apply(cells);
    assertTrue(returned2 instanceof CVBool);
    assertEquals(returned2.toString(), "false");

    cells.clear();
    cells.add(addObj2);
    cells.add(addObj2);
    CellValue returned3 = compObj.apply(cells);
    assertTrue(returned3 instanceof CVBool);
    assertEquals(returned3.toString(), "false");
  }
}
