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

public class MainMapController extends Controller {

  @FXML
  protected String getSceneResourceName() {
    return "resources/MainMapScreen.fxml";
  }

  @FXML
  public ImageView townView;


}
