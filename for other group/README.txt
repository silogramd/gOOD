The view jframes both share the same jpanel (SpreadsheetGUIViewPanel.java).

The normal view is SpreadsheetFrameView.java and the editable is SpreadsheetEditableView.java.

There is a grid of text fields, each has a view event listener. The controller overrides the view
event listener, and when actions are performed in the view, the view calls the methods from the
controller (defined in the view event listener interface).

 - clicking on a cell highlights it.
 - Scrolling is handled by buttons.
 - User input is typed into the text bar on the top and entered using the confirm button.
 - The reset button moves the user back to the coord 1,1.
 - the save file as and load file buttons load or save the file defined in the following text box.
