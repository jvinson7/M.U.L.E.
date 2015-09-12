package controllers;

import main.java.FlowHandler;
import com.sun.javafx.collections.ImmutableObservableList;
import javafx.beans.binding.BooleanBinding;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import model.GameConfiguration;
import model.Difficulty;

public class GameConfigurationController extends Controller {

  private GameConfiguration gameConfig;
  private FlowHandler flowHandler;

  public GameConfigurationController(FlowHandler flowHandler) {
    this.flowHandler = flowHandler;
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

    // Populate number of players box.
    numberOfPlayersSelector.getItems()
      .setAll(new ImmutableObservableList<Integer>(1, 2, 3, 4));

    // Enable done button when a difficulty and the number of players have been
    // selected.
    BooleanBinding gameConfigured = gameConfig.isConfigured;
    doneButton.disableProperty().bind(gameConfigured.not());

    // Bind UI to GameConfiguration model.
    gameConfig.numberOfPlayersProperty()
      .bindBidirectional(numberOfPlayersSelector.valueProperty());
    gameConfig.difficultyProperty()
      .bindBidirectional(difficultySelector.valueProperty());
  }

  @FXML
  private void done(Event event) {
    System.out.println("Done pressed. Event: " + event);
    flowHandler.configurePlayers(gameConfig.getNumberOfPlayers(), gameConfig.getDifficulty());
  }
}
