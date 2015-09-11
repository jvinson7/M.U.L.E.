package main.java;

import controllers.PlayerConfigurationController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * The Launcher is the starting point for our JavaFX Application.
 * @author Kevin Randrup
 */
public class Launcher extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		//Example configuration. This will be changed later.
		PlayerConfigurationController controller = new PlayerConfigurationController(4);
		Scene scene = controller.getScene();
		primaryStage.setScene(scene);
		primaryStage.show();		
	}	
}
