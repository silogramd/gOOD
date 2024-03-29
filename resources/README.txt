WHAT WORKS: All of the basic functions work. Clicking to select a cell, updating cell values
through the text field at the top of the screen, updating the selected cell by clicking the check
button, and clearing the cell by clicking the x button.

WHAT DOESNT WORK: Because our view handled saving and loading, and we did not handle keys, we were
unable to get all of the additional features such as using arrows to move, backspace to clear, and
files to save and load.










VIEW Interface:
  - Render: renders the view the first time
  - Refresh: updates the view after a change

TextualView:
  - takes an appendable and a model
  - Uses render to append the textual view of the model to the appendable
  - refresh does the same thing

Frame view:
  - Uses textfields for input boxes and buttons for scrolling.
  - includes a save button that saves the project to a new file and a reset button
        to reset the orientation.


Changes:
  - adding type parameters to the view and model interfaces
      so that later on different types of cells may be used
  - adding a hashmap function -> cell value to avoid re-evaluating cell values (efficiency)


MODEL Interfaces and sub classes

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

