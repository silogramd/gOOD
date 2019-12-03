package edu.cs3500.spreadsheets.provider.controller;

import edu.cs3500.spreadsheets.controller.SpreadSheetController;
import edu.cs3500.spreadsheets.provider.model.ModelAdapter;
import edu.cs3500.spreadsheets.provider.view.VisualWorksheetView;
import edu.cs3500.spreadsheets.provider.view.WorksheetView;
import java.io.IOException;

public class ControllerAdapter implements WorksheetController {

  ModelAdapter model;
  WorksheetView view;

  public ControllerAdapter(ModelAdapter model, SpreadSheetController controller) {
    this.model = model;
    this.view = new VisualWorksheetView(model);
    view.addFeatures(new FeaturesAdapter(controller));
  }

  @Override
  public void goRender() throws IOException {
    view.render();
  }
}
