package edu.cs3500.spreadsheets.provider.model;

import edu.cs3500.spreadsheets.model.CVBlank;
import edu.cs3500.spreadsheets.model.CVBool;
import edu.cs3500.spreadsheets.model.CVDouble;
import edu.cs3500.spreadsheets.model.CVError;
import edu.cs3500.spreadsheets.model.CVString;
import edu.cs3500.spreadsheets.model.CellValueVisitor;

public class VisitorAdapter<R> implements CellValueVisitor {

  private ValueVisitor<R> visitor;

  public VisitorAdapter(ValueVisitor<R> visitor) {
    this.visitor = visitor;
  }

  /**
   * <p>Visit method for a {@link CVDouble}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  @Override
  public R visitDouble(CVDouble cv) {
    return visitor.visitValueDouble(Double.valueOf(cv.toString()));
  }

  /**
   * <p>Visit method for a {@link CVError}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  @Override
  public R visitError(CVError cv) {
    return visitor.visitErr(new ExceptionAdapter(cv));
  }

  /**
   * <p>Visit method for a {@link CVBlank}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  @Override
  public R visitBlank(CVBlank cv) {
    return visitor.visitBlankValue();
  }

  /**
   * <p>Visit method for a {@link CVBool}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  @Override
  public R visitBool(CVBool cv) {
    return visitor.visitValueBoolean(Boolean.valueOf(cv.toString()));
  }

  /**
   * <p>Visit method for a {@link CVString}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  @Override
  public R visitString(CVString cv) {
    return visitor.visitValueString(cv.toString());
  }
}
