package main.java;

import controllers.GameConfigurationController;
import controllers.PlayerConfigurationController;
import controllers.Controller;
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
 * The FlowHandler maps events between screens so everything works nicely
 * @author Maximillian von Briesen
 */
public class FlowHandler {
  private Stage primaryStage;
  private GameConfiguration gameConfig;
  private List<PlayerConfiguration> playerConfigs;

	public FlowHandler(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  public void configureGame() {
    GameConfigurationController gameConfig = new GameConfigurationController(this);
    switchScene(gameConfig);
  }

  public void configurePlayers(GameConfiguration gameConfig) {
    this.gameConfig = gameConfig;
    int numPlayers = gameConfig.getNumberOfPlayers();
    PlayerConfigurationController playerConfig = new PlayerConfigurationController(numPlayers, this);
    switchScene(playerConfig);
  }

  public void startGame(List<PlayerConfiguration> playerConfigs) {
    this.playerConfigs = playerConfigs;
    System.out.println("success!");

    String resourceName = "resources/FillerScreen.fxml";
    ClassLoader loader = getClass().getClassLoader();
    URL url = loader.getResource(resourceName);
    Parent root = null;
    try {
      FXMLLoader fxLoader = new FXMLLoader();
      fxLoader.setController(this);
      fxLoader.setLocation(url);
      root = fxLoader.load();

      Scene scene = new Scene(root, 300, 275);
      primaryStage.setTitle("Filler Page");
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      System.out.println("Failed to create scene with resource name: " + resourceName);
      e.printStackTrace();
    }
  }

  private void switchScene(Controller c) {
    Scene scene = c.getScene();
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
