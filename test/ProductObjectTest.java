import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CellValue;
import edu.cs3500.spreadsheets.model.Operation;
import edu.cs3500.spreadsheets.model.ProductObject;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * <p>Class representing ProductObject tests.</p>
 */
public class ProductObjectTest {

  @Test
  public void applyTest() {

    CellValue addObj1 = new CVDouble(1.0);
    CellValue addObj2 = new CVDouble(2.0);
    CellValue blankObj = new CVBlank();
    CellValue boolObj = new CVBool(false);
    CellValue errObj = new CVError();
    CellValue stringObj = new CVString("test");

    Operation productObj = new ProductObject();
    ArrayList<CellValue> cells = new ArrayList<>();

    cells.add(addObj1);
    cells.add(addObj2);
    assertFalse(productObj.apply(cells) instanceof CVError);
    cells.add(blankObj);
    assertFalse(productObj.apply(cells) instanceof CVError);
    cells.add(boolObj);
    assertFalse(productObj.apply(cells) instanceof CVError);
    cells.add(stringObj);
    assertFalse(productObj.apply(cells) instanceof CVError);
    cells.add(errObj);
    assertTrue(productObj.apply(cells) instanceof CVError);

    cells.remove(errObj);
    CellValue returned = productObj.apply(cells);
    assertTrue(returned instanceof CVDouble);
    assertEquals(returned.toString(), "2.000000");

  }
}
