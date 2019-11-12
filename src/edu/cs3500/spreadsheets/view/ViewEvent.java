package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Coord;

public interface ViewEvent {

  void updateCell(Coord coord, String s);

}
