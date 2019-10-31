import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CellValue;
import edu.cs3500.spreadsheets.model.CompareObject;
import edu.cs3500.spreadsheets.model.Operation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


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

    assertFalse(compObj.apply(addObj1, addObj2) instanceof CVError);
    assertTrue(compObj.apply(blankObj, boolObj) instanceof CVError);
    assertTrue(compObj.apply(addObj1, boolObj) instanceof CVError);
    assertTrue(compObj.apply(addObj1, stringObj) instanceof CVError);
    assertTrue(compObj.apply(addObj1, errObj) instanceof CVError);


    CellValue returned = compObj.apply(addObj1, addObj2);
    assertTrue(returned instanceof CVBool);
    assertEquals(returned.toString(), "true");

    CellValue returned2 = compObj.apply(addObj2, addObj1);
    assertTrue(returned2 instanceof CVBool);
    assertEquals(returned2.toString(), "false");

    CellValue returned3 = compObj.apply(addObj2, addObj2);
    assertTrue(returned3 instanceof CVBool);
    assertEquals(returned3.toString(), "false");
  }
}
