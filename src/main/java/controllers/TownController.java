package controllers;

import main.java.GameplayController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.Event;


public class TownController extends Controller {

  private GameplayController gameplayController;

  public TownController(GameplayController gameplayController){
    this.gameplayController = gameplayController;
  }

  @FXML
  protected String getSceneResourceName() {
    return "resources/TownScreen.fxml";
  }

  @FXML
  public void viewMainMap(Event event){
    gameplayController.viewMainMap();
  }




}
