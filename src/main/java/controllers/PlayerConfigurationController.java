package controllers;

import main.java.GameController;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import model.Race;
import model.PlayerConfiguration;

/**
 * The PlayerConfigurationScreen allows a number of players to be configured with a name, race and color.
 * @author Kevin Randrup
 */
public class PlayerConfigurationController extends Controller {

	private List<PlayerConfiguration> playerConfigs;
	private PlayerConfiguration currentConfiguration;
	private GameController gameController;

	public PlayerConfigurationController(Integer playerCount, GameController gameController) {
		this.gameController = gameController;
		playerConfigs = new ArrayList<>();
		for (int i = 0; i < playerCount; i++) {
			PlayerConfiguration config = new PlayerConfiguration();
			config.setName("Player " + (i + 1));
			playerConfigs.add(config);
		}
	}

	@FXML
	private Button doneButton;

	@FXML
	private TextField nameTextField;

	@FXML
	private ColorPicker colorPicker;

	@FXML
	private ComboBox<Race> raceComboBox;

	@FXML
	private ButtonBar buttonBar;

	@Override
	protected String getSceneResourceName() {
		return "resources/PlayerConfigurationScreen.fxml";
	}

	@FXML
	public void initialize() {
		//Setup the ButtonBar with Player 1, Player 2...
		for (int i = 0; i < playerConfigs.size(); i++) {
			//Create button
			Button playerButton = new Button();
			PlayerConfiguration config = playerConfigs.get(i);
			playerButton.textProperty().bind(config.nameProperty());
			config.isConfigured.addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (newValue) { //Is not configured
						//Make the button green whenever is is configured
						playerButton.setStyle("-fx-base: #b6e7c9;");
					} else {
						playerButton.setStyle(null);
					}
				}
			});

			//Add button
			ButtonBar.setButtonData(playerButton, ButtonData.LEFT);
			buttonBar.getButtons().add(playerButton);

			//When a button is tapped then change the current configuration
			playerButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					int selectedIndex = buttonBar.getButtons().indexOf(event.getSource());
					showConfig(playerConfigs.get(selectedIndex));
				}
			});
		}

		//Populate the race box
		raceComboBox.setItems(Race.allRaces);

		//Initial setup of player configuration
		showConfig(playerConfigs.get(0));

		//When all of the PlayerConfigurations are configured, enabled the done button
		BooleanBinding allConfigured = null;
		for (PlayerConfiguration config : playerConfigs) {
			if (allConfigured == null) {
				allConfigured = config.isConfigured;
			} else {
				allConfigured = allConfigured.and(config.isConfigured);
			}
		}
		doneButton.disableProperty().bind(allConfigured.not());
	}

	/**
	 * Changes the user interface to show a different player configuration
	 * @param config any PlayerConfiguration
	 */
	private void showConfig(PlayerConfiguration config) {

		if (currentConfiguration == config) return;

		//Remove old bindings if they exist
		if (currentConfiguration != null) {
			currentConfiguration.nameProperty().unbindBidirectional(nameTextField.textProperty());
			currentConfiguration.raceProperty().unbindBidirectional(raceComboBox.valueProperty());
			currentConfiguration.colorProperty().unbindBidirectional(colorPicker.valueProperty());
		}

		//Set the properties
		nameTextField.setText(config.getName());
		raceComboBox.setValue(config.getRace());
		colorPicker.setValue(config.getColor());

		//Bind the new configuration to our UI
		config.nameProperty().bindBidirectional(nameTextField.textProperty());
		config.raceProperty().bindBidirectional(raceComboBox.valueProperty());
		config.colorProperty().bindBidirectional(colorPicker.valueProperty());

		currentConfiguration = config;
	}

	@FXML
	private void done(Event event) {
		System.out.println("Done pressed. Event: " + event);
		gameController.doneConfiguringPlayers(playerConfigs);
	}
}
