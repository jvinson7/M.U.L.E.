package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import model.GameConfiguration;

public class GameConfigurationController extends Controller {

  private GameConfiguration gameConfig;

  public GameConfigurationController() {
    gameConfig = new GameConfiguration();
  }

  @FXML
  protected String getSceneResourceName() {
    return "resources/GameConfigurationScene.fxml";
  }

  @FXML
  public void initialize() {
    // Populate difficulty box.
    difficultySelector.setItems(Difficulty.allDifficulties);
  }

  @FXML
  private Button doneButton;

  @FXML
  private ChoiceBox numberOfPlayersSelector;

  @FXML
  private ChoiceBox difficultySelector;
}
