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
  private int turn;
  private boolean propertySelectedThisTurn = false; //default value
                                                    //reset when turn increments.
  private int playerTurn = 0; //go to 0 to playerConfigs.size() of List.
                              //reset to 0 and increment turn when done.

  public GameplayController(Stage primaryStage, GameConfiguration gameConfig, List<PlayerConfiguration> playerConfigs) {
    this.primaryStage = primaryStage;
    this.gameConfig = gameConfig;
    this.playerConfigs = playerConfigs;
  }

  public void startGame() {
    mainMapController = new MainMapController(this);
    townController = new TownController(this);
    turn = 1;
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

  private boolean grantLand(Plot plot, PlayerConfiguration player) {
    if (turn <= 2) {
      if (plot.getOwner() == null) {
        propertySelectedThisTurn = true;
        plot.setOwner(player);
        return true;
      }
      return false;
    }
    if (plot.getOwner() == null && player.deductFunds(300)) {
      plot.setOwner(player);
      propertySelectedThisTurn = true;
      return true;
    }
    return false;
  }
}
