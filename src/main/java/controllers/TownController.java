package controllers;

import main.java.GameController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.Event;


public class TownController extends Controller {

  private GameController gameController;

  public TownController(GameController gameController){
    this.gameController = gameController;
  }

  @FXML
  protected String getSceneResourceName() {
    return "resources/TownScreen.fxml";
  }

  @FXML
  public void viewMainMap(Event event){
    gameController.viewMainMap();
  }




}
