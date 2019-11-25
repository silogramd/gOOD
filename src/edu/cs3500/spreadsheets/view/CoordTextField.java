package edu.cs3500.spreadsheets.view;

import javax.swing.JTextField;

/**
 * Wrapper class representing a textfield in a grid.
 */
public class CoordTextField {

  final int row, col;
  final JTextField field;

  public CoordTextField(JTextField field, int row, int col) {
    this.row = row;
    this.col = col;
    this.field = field;
  }

}
