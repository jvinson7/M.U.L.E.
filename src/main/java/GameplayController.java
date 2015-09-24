package main.java;

import controllers.*;
import model.GameConfiguration;
import model.Plot;
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
  private int round;
  private boolean propertySelectedThisTurn = false;

  private int playerTurn = 0;


  public GameplayController(Stage primaryStage, GameConfiguration gameConfig, List<PlayerConfiguration> playerConfigs) {
    this.primaryStage = primaryStage;
    this.gameConfig = gameConfig;
    this.playerConfigs = playerConfigs;
  }

  public void startGame() {
    mainMapController = new MainMapController(this);
    townController = new TownController(this);
    round = 1;
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

  public PlayerConfiguration getCurrentPlayer(){
    return playerConfigs.get(playerTurn);
  }

  public int getRound(){
    return round;
  }

  public void endPlayerTurn(){
    if(++playerTurn >= playerConfigs.size()){
      playerTurn = 0;
      round++;
    } else {
      playerTurn++;
    }
  }
}
