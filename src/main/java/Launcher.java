package main.java;

import main.java.GameController;
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
		GameController gameController = new GameController(primaryStage);
		gameController.configureGame();
	}
}
