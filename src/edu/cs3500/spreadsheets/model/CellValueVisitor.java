package edu.cs3500.spreadsheets.model;

/**
 * <p>Interface for Visitors of the {@link CellValue} abstract class.</p>
 *
 * @param <R> the return type for the implementation.
 */
public interface CellValueVisitor<R> {

  /**
   * <p>Visit method for a {@link CVDouble}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  R visitDouble(CVDouble cv);

  /**
   * <p>Visit method for a {@link CVError}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  R visitError(CVError cv);

  /**
   * <p>Visit method for a {@link CVBlank}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  R visitBlank(CVBlank cv);

  /**
   * <p>Visit method for a {@link CVBool}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  R visitBool(CVBool cv);

  /**
   * <p>Visit method for a {@link CVString}.</p>
   *
   * @param cv the value being visited.
   * @return the output, parameterized by the class.
   */
  R visitString(CVString cv);

}
