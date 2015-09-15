package controllers;

import com.sun.javafx.collections.ImmutableObservableList;
import javafx.beans.binding.BooleanBinding;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import model.GameConfiguration;
import model.Difficulty;
import model.LevelMap;

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
  public ChoiceBox levelMapSelector;
  
  @FXML
  public void initialize() {
    // Populate difficulty box.
    difficultySelector.getItems().setAll(Difficulty.allDifficulties);

    // Populate number of players box.
    numberOfPlayersSelector.getItems()
      .setAll(new ImmutableObservableList<Integer>(1, 2, 3, 4));
 
    // Populate level map box.
    levelMapSelector.getItems().setAll(LevelMap.allLevelMaps);

    // Enable done button when a difficulty and the number of players have been
    // selected.
    BooleanBinding gameConfigured = gameConfig.isConfigured;
    doneButton.disableProperty().bind(gameConfigured.not());

    // Bind UI to GameConfiguration model.
    gameConfig.numberOfPlayersProperty()
      .bindBidirectional(numberOfPlayersSelector.valueProperty());
    gameConfig.difficultyProperty()
      .bindBidirectional(difficultySelector.valueProperty());
    gameConfig.levelMapProperty()
      .bindBidirectional(levelMapSelector.valueProperty());
  }

  @FXML
  private void done(Event event) {
    System.out.println("Done pressed. Event: " + event);
  }
}
