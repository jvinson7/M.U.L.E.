package controllers;

import main.java.GameplayController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.Event;



public class MainMapController extends Controller {

  private GameplayController gameplayController;

  public MainMapController(GameplayController gameplayController) {
    this.gameplayController = gameplayController;
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
    gameplayController.goToTown();
  }
}
