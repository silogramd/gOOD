import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CellValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>Class representing CellValue tests.</p>
 */
public class CellValueTest {

  @Test
  public void getValue() {
    CellValue addObj1 = new CVDouble(1.0);
    CellValue blankObj = new CVBlank();
    CellValue boolObj = new CVBool(false);
    CellValue errObj = new CVError();
    CellValue stringObj = new CVString("test");

    assertEquals(addObj1.toString(), "1.000000");
    assertEquals(blankObj.toString(), "");
    assertEquals(boolObj.toString(), "false");
    assertEquals(errObj.toString(), "#ERROR");
    assertEquals(stringObj.toString(), "test");
  }
}