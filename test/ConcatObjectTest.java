import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CellValue;
import edu.cs3500.spreadsheets.model.ConcatObject;
import edu.cs3500.spreadsheets.model.Operation;
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

    assertFalse(concatObj.apply(addObj1, addObj2) instanceof CVError);
    assertFalse(concatObj.apply(blankObj, boolObj) instanceof CVError);
    assertFalse(concatObj.apply(addObj1, boolObj) instanceof CVError);
    assertFalse(concatObj.apply(addObj1, stringObj1) instanceof CVError);
    assertTrue(concatObj.apply(addObj1, errObj) instanceof CVError);
    assertFalse(concatObj.apply(addObj1, blankObj) instanceof CVError);


    CellValue returned = concatObj.apply(addObj1, addObj2);
    assertTrue(returned instanceof CVString);
    assertEquals(returned.toString(), "1.0000002.000000");

    CellValue returned2 = concatObj.apply(stringObj1, stringObj2);
    assertTrue(returned2 instanceof CVString);
    assertEquals(returned2.toString(), "testcat");

    CellValue returned3 = concatObj.apply(stringObj1, errObj);
    assertTrue(returned3 instanceof CVError);
    assertEquals(returned3.toString(), "#ERROR");
  }
}
