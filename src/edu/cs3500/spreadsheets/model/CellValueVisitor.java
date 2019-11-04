package edu.cs3500.spreadsheets.model;

public interface CellValueVisitor<R> {

  R visitDouble(CVDouble cv);

  R visitError(CVError cv);

  R visitBlank(CVBlank cv);

  R visitBool(CVBool cv);

  R visitString(CVString cv);

}
