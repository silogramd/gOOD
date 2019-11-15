import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CellValue;
import edu.cs3500.spreadsheets.model.ConcatObject;
import edu.cs3500.spreadsheets.model.Operation;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * <p>Class representing ConcatObject tests.</p>
 */
public class ConcatObjectTest {

  @Test
  public void applyTest() {

    CellValue addObj1 = new CVDouble(1.0);
    CellValue addObj2 = new CVDouble(2.0);
    CellValue blankObj = new CVBlank();
    CellValue boolObj = new CVBool(false);
    CellValue errObj = new CVError();
    CellValue stringObj1 = new CVString("test");
    CellValue stringObj2 = new CVString("cat");

    Operation concatObj = new ConcatObject();

    ArrayList<CellValue> cells = new ArrayList<>();

    cells.add(addObj1);
    cells.add(addObj2);
    assertFalse(concatObj.apply(cells) instanceof CVError);
    cells.add(blankObj);
    assertFalse(concatObj.apply(cells) instanceof CVError);
    cells.add(boolObj);
    assertFalse(concatObj.apply(cells) instanceof CVError);
    cells.add(stringObj1);
    assertFalse(concatObj.apply(cells) instanceof CVError);
    cells.add(errObj);
    assertTrue(concatObj.apply(cells) instanceof CVError);

    cells.remove(errObj);
    CellValue returned = concatObj.apply(cells);
    assertTrue(returned instanceof CVString);
    assertEquals(returned.toString(), "1.0000002.000000falsetest");

    cells.add(errObj);
    CellValue returned3 = concatObj.apply(cells);
    assertTrue(returned3 instanceof CVError);
    assertEquals(returned3.toString(), "#ERROR");
  }
}
