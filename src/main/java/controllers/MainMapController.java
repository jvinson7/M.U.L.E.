package controllers;

import main.java.GameController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.Event;



public class MainMapController extends Controller {

  private GameController gameController;

  public MainMapController(GameController gameController) {
    this.gameController = gameController;
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
    gameController.goToTown();
  }
}
