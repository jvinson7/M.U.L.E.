package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import model.GameConfiguration;
import model.Difficulty;

public class GameConfigurationController extends Controller {

  private GameConfiguration gameConfig;

  public GameConfigurationController() {
    gameConfig = new GameConfiguration();
  }

  @FXML
  protected String getSceneResourceName() {
    return "resources/GameConfigurationScreen.fxml";
  }

  @FXML
  public Button doneButton;

  @FXML
  public ChoiceBox numberOfPlayersSelector;

  @FXML
  public ChoiceBox difficultySelector;
  
  @FXML
  public void initialize() {
    // Populate difficulty box.
    difficultySelector.getItems().setAll(Difficulty.allDifficulties);
  }
}
