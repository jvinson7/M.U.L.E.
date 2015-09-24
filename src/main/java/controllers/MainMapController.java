package controllers;

import main.java.GameplayController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.Event;

import java.util.Integer;

public class MainMapController extends Controller {

  private GameplayController gameplayController;
  private Plot[][] plots;
  int height = 8;
  int width = 10;
  public MainMapController(GameplayController gameplayController) {
    this.gameplayController = gameplayController;
    plots = new Plot[height][width];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 10; j++) {
        plot[i][j] = new Plot(i, j);
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
       Canvas canvas = (Canvas) (event.getSource());
       String id = canvas.getId();
       int loc = Integer.parseInt(id.substring(4));
      plot = gameplayController.getPlot(loc/11, loc%11);
      PlayerConfiguration player = gameplayController.getCurrentPlayer();

      if (gameplayController.getRound() <= 2 && plot.getOwner() == null) {
          plot.setOwner(player);
          canvas.getGraphicsContext().setFill(player.getColor());
          gameplayController.endPlayerTurn();
      }
      if (plot.getOwner() == null && player.deductFunds(300)) {
        plot.setOwner(player);
        canvas.getGraphicsContext().setFill(player.getColor());
        gameplayController.endPlayerTurn()
      }
  }

  private boolean grantLandHelper(Plot plot) {


  }
}
