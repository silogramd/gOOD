package edu.cs3500.spreadsheets.model;

import java.util.HashMap;

/**
 * Represents a basic version of a spreadsheet model
 */
public class BasicSpreadsheetModel implements SpreadsheetModel {

  private HashMap<Coord, String> hashMap = new HashMap<>();

  @Override
  public String getCellAt(Coord coord) {
    String cur;

    if(hashMap.containsKey(coord)) {
       cur = hashMap.get(coord);

       if(cur.charAt(0) == '(' && cur.length() > 1) {
         return handleFunction(coord, cur.substring(1, cur.length() - 2));
       } else {
         return cur;
       }
    } else {
      throw new IllegalArgumentException("empty cell");
    }
  }

  @Override
  public String handleFunction(Coord coord, String string) {
    String[] args = string.split(" ");

    switch(args[0]){
      case "SUM":
        return sumHelp(args);
        //todo
        break;
      case "PRODUCT":

        return productHelp(args);
        //todo
        break;
      case "<":

        return compareHelp(args);
        //todo
        break;
      case "CONCAT":

        return concatHelp(args);
        //todo
        break;
      default:
        throw new IllegalArgumentException("not valid formula specifier");

    }

    return null;
  }


  @Override
  public String getRawCellAt(Coord coord) {
    if(hashMap.containsKey(coord)) {
      return hashMap.get(coord);
    } else {
      throw new IllegalArgumentException("empty cell");
    }
  }

  @Override
  public void editCell(Coord coord, String string) {

    if(!(hashMap.containsKey(coord))) {
      hashMap.put(coord, string);
    } else {
      hashMap.replace(coord, string);
    }

  }


  private void sumHelp(String[] args) {

    for (String s : args) {
      if (s.contains("(")) {

      }
    }

  }



}
