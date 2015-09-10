package controllers;

/**
 * The PlayerConfigurationScreen allows a number of players to be configured with a name, race and color.
 * @author Kevin Randrup
 *
 */
public class PlayerConfigurationController extends Controller {
	
	public PlayerConfigurationController(Integer playerCount) {
		
	}
	
	@Override
	protected String getSceneResourceName() {
		return "resources/PlayerConfigurationScreen.fxml";
	}

	@FXML
	public void initialize() {
		System.out.println("Initialize called");
	}
}
