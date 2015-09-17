package controllers;

import main.java.FlowHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.Event;


public class TownController extends Controller {

  private FlowHandler flowHandler;

  public TownController(FlowHandler flowHandler){
    this.flowHandler = flowHandler;
  }

  @FXML
  protected String getSceneResourceName() {
    return "resources/TownScreen.fxml";
  }

  @FXML
  public void viewMainMap(Event event){
    flowHandler.viewMainMap();
  }




}
