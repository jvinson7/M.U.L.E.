package controllers;

import main.java.FlowHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.Event;



public class MainMapController extends Controller {

  private FlowHandler flowHandler;

  public MainMapController(FlowHandler flowHandler){

    this.flowHandler = flowHandler;

  }

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
