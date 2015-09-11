package controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * The PlayerConfigurationScreen allows a number of players to be configured with a name, race and color.
 * @author Kevin Randrup
 */
public class PlayerConfigurationController extends Controller {
	
	public PlayerConfigurationController(Integer playerCount) {
		
	}
	
	@FXML
	private Button doneButton;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private ColorPicker colorPicker;
	
	@FXML
	private ComboBox/*<Race>*/ raceComboBox;
	
			
	@Override
	protected String getSceneResourceName() {
		return "resources/PlayerConfigurationScreen.fxml";
	}

	@FXML
	public void initialize() {
		System.out.println("Initialize called");
				
		System.out.println("Done button: " + doneButton);
		System.out.println("Name: " + nameTextField);
		System.out.println("Color picker: " + colorPicker);
		System.out.println("Race: " + raceComboBox);
	}
	
	@FXML
	private void done(Event event) {
		System.out.println("Done pressed. Event: " + event);
	}

}
