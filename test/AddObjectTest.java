import edu.cs3500.spreadsheets.model.AddObject;
import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CellValue;
import edu.cs3500.spreadsheets.model.Operation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * <p>Class representing AddObject tests.</p>
 */
public class AddObjectTest {
  @Test
  public void applyTest() {

    CellValue addObj1 = new CVDouble(1.0);
    CellValue addObj2 = new CVDouble(2.0);
    CellValue blankObj = new CVBlank();
    CellValue boolObj = new CVBool(false);
    CellValue errObj = new CVError();
    CellValue stringObj = new CVString("test");

    Operation addOp = new AddObject();

    assertFalse(addOp.apply(addObj1, addObj2) instanceof CVError);
    assertTrue(addOp.apply(blankObj, boolObj) instanceof CVError);
    assertTrue(addOp.apply(addObj1, boolObj) instanceof CVError);
    assertTrue(addOp.apply(addObj1, stringObj) instanceof CVError);
    assertTrue(addOp.apply(addObj1, errObj) instanceof CVError);


    CellValue returned = addOp.apply(addObj1, addObj2);
    assertTrue(returned instanceof CVDouble);
    assertEquals(returned.toString(), "3.000000");

  }
}
