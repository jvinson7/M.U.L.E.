package main.java;

import main.java.GameplayController;
import controllers.*;
import model.GameConfiguration;
import model.PlayerConfiguration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.List;

// for filler screen
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.net.URL;
import java.io.IOException;

/**
 * The GameController deals with game configuration, kicking off gameplay, and ending the game
 * @author Maximillian von Briesen
 */
public class GameController {
  // configurations
  private GameConfiguration gameConfig;
  private List<PlayerConfiguration> playerConfigs;

  // controllers
  private GameplayController gameplayController;
  private GameConfigurationController gameConfigController;
  private PlayerConfigurationController playerConfigController;
  private MainMapController mainMapController;
  private TownController townController;

  // other
  private Stage primaryStage;

	public GameController(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  public void configureGame() {
    gameConfigController = new GameConfigurationController(this);
    switchScene(gameConfigController);
  }

  public void doneConfiguringGame(GameConfiguration gameConfig) {
    this.gameConfig = gameConfig;
    configurePlayers();
  }

  public void configurePlayers() {
    int numPlayers = gameConfig.getNumberOfPlayers();
    playerConfigController = new PlayerConfigurationController(numPlayers, this);
    switchScene(playerConfigController);
  }

  public void doneConfiguringPlayers(List<PlayerConfiguration> playerConfigs) {
    this.playerConfigs = playerConfigs;
    startGame();
  }

  public void startGame() {
    mainMapController = new MainMapController(this);
    townController = new TownController(this);
    switchScene(mainMapController);
  }

  public void goToTown(){
    switchScene(townController);
  }

  public void viewMainMap(){
    switchScene(mainMapController);
  }

  private void switchScene(Controller c) {
    Scene scene = c.getScene();
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
