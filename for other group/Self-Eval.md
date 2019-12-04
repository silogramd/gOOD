Changes made for the customers included adding a CellValue interface
 and changing a few instances where we set fields or constructor arguments 
 to our implementation, rather than our interfaces.
 
**CellValue** - Initially we had a Formula interface that had references,
    functions, and basic cell values as subclasses. This became a problem
    because our model interface methods returned a basic cell value and
    not the formula interface. We decided to add an interface for 
    basic cell values, and our abstract implementation of cell values
    subclassed both the formula and cell value interfaces.
   
**Arguments** - There were several instances in constructors, fields, and
    method arguments where we used our implementation classes rather
    than the interfaces. We had to change these instances so that
    the customers could use the methods and constructors with their
    own adapter implementations of our interfaces. This was necessary
    to avoid having to send them our specific implementations in order
    for the code to run.