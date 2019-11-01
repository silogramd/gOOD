Interfaces and sub classes

SpreadsheetModel: the interface for all models
  - BasicSpreadsheetModel: basic implementation of a spreadsheet

ICell: interface for all cells
  - Cell: Basic implementation of a cell, stores it's coords, raw contents, and evaluated contents

Operation: interface for types of operations
  - AddObject: For adding cell values
  - CompareObject: For comparing cell values in the format (cell1) < (cell2)
  - ConcatObject: For concatenating cells as a string
  - Product Object: For multiplying cell values

Formula: interface for cellValues, functions, and references
  - CellValue: Abstract class for the cell value type of formula objects
    - CVBlank: blank cell value
    - CVBool: boolean cell value
    - CVDouble: double cell value
    - CVError: error cell value
    - CVString: string cell value
  - Function: Represents a formula with a function, methods for flattening and evaluating
  - Reference: Represents a formula with a reference, handles box and single references

 WorkSheetBuilderImpl: Creates a list of cells and adds them to the basic spreadsheet model

 ContentsBuilder: Creates formulas out of Sexpressions

