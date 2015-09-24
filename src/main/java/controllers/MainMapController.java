package controllers;

import model.Plot;
import model.PlayerConfiguration;
import main.java.GameplayController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.Event;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.lang.Integer;

public class MainMapController extends Controller {

  private GameplayController gameplayController;
  private Plot[][] plots;
  int height = 9;
  int width = 11;
  public MainMapController(GameplayController gameplayController) {
    this.gameplayController = gameplayController;
    plots = new Plot[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        plots[i][j] = new Plot(i, j);
      }
    }
    plots[4][5].setTown();
  }

  @FXML
  protected String getSceneResourceName() {
    return "resources/MainMapScreen.fxml";
  }

  @FXML
  public ImageView townView;

  @FXML
  private void enterTown(Event event) {
    System.out.println("Done pressed. Event: " + event);
    gameplayController.goToTown();
  }

  @FXML
  private void grantLand(Event event) {
    System.out.println("SOmething happened");
       Canvas canvas = (Canvas) (event.getSource());
       String id = canvas.getId();
       System.out.println(id);
       int loc = Integer.parseInt(id.substring(4));
       System.out.println(loc);
      Plot plot = plots[loc/11][loc%11];
      PlayerConfiguration player = gameplayController.getCurrentPlayer();


      if (gameplayController.getRound() <= 2 && plot.getOwner() == null) {
        System.out.println(colorString(player.getColor()));
          plot.setOwner(player);
          canvas.getGraphicsContext2D().setFill(player.getColor());
          canvas.getGraphicsContext2D().fill();
          canvas.getGraphicsContext2D().stroke();
          gameplayController.endPlayerTurn();
      }
      if (plot.getOwner() == null && player.deductFunds(300)) {
        plot.setOwner(player);
        canvas.getGraphicsContext2D().setFill(player.getColor());
        canvas.getGraphicsContext2D().fill();
        canvas.getGraphicsContext2D().stroke();
        gameplayController.endPlayerTurn();
      }
  }

  private String colorString(Color color){
    return "" + color.getBlue() + " " + color.getRed() + " " + color.getGreen();
  }

}
