package controllers;

import main.java.FlowHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;



public class MainMapController extends Controller {

  @FXML
  protected String getSceneResourceName() {
    return "resources/MainMapScreen.fxml";
  }

  @FXML
  public ImageView townView;

  @FXML
  private void enterTown(Event event) {
    System.out.println("Done pressed. Event: " + event);
    flowHandler.goToTown();
  }
}
