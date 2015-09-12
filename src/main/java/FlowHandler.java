package main.java;

import controllers.GameConfigurationController;
import controllers.PlayerConfigurationController;
import controllers.Controller;
import model.Difficulty;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * The FlowHandler maps events between screens so everything works nicely
 * @author Maximillian von Briesen
 */
public class FlowHandler {
  private Stage primaryStage;
  private Difficulty difficulty;

	public FlowHandler(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  public void configureGame() {
    GameConfigurationController gameConfig = new GameConfigurationController(this);
    switchScene(gameConfig);
  }

  public void configurePlayers(int numPlayers, Difficulty difficulty) {
    this.difficulty = difficulty;
    PlayerConfigurationController playerConfig = new PlayerConfigurationController(numPlayers, this);
    switchScene(playerConfig);
  }

  public void startGame() {

  }

  private void switchScene(Controller c) {
    Scene scene = c.getScene();
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
