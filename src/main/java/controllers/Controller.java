package controllers;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;

public abstract class Controller {

	protected Scene scene;

	public Scene getScene() {
		if (scene == null) {
			String resourceName = getSceneResourceName();
			ClassLoader loader = getClass().getClassLoader();
			URL url = loader.getResource(resourceName);
			Parent root = null;
			try {
				FXMLLoader fxLoader = new FXMLLoader();
				fxLoader.setController(this);
				fxLoader.setLocation(url);
				root = fxLoader.load();
			} catch (IOException e) {
				System.out.println("Failed to create scene with resource name: " + resourceName);
				e.printStackTrace();
			}

			scene = new Scene(root);
		}
		return scene;
	}

	/**
	 * Subclasses must override this method to provide a fxml document to load the scene from.
	 * @return "ResourceName.fxml"
	 */
	protected abstract String getSceneResourceName();
}
