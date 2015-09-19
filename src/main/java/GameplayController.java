package main.java;

import controllers.*;
import model.GameConfiguration;
import model.PlayerConfiguration;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.List;

public class GameplayController {
  private Stage primaryStage;
  private GameConfiguration gameConfig;
  private List<PlayerConfiguration> playerConfigs;
  private MainMapController mainMapController;
  private TownController townController;

  public GameplayController(Stage primaryStage, GameConfiguration gameConfig, List<PlayerConfiguration> playerConfigs) {
    this.primaryStage = primaryStage;
    this.gameConfig = gameConfig;
    this.playerConfigs = playerConfigs;
  }

  public void startGame() {
    mainMapController = new MainMapController(this);
    townController = new TownController(this);
    switchScene(mainMapController);
  }

  public void goToTown() {
    switchScene(townController);
  }

  public void viewMainMap() {
    switchScene(mainMapController);
  }

  private void switchScene(Controller c) {
    Scene scene = c.getScene();
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void grantLand(Plot plot, PlayerConfiguration player) {
      plot.setOwner(player);
  }
}
