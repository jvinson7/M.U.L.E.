package test.java.modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.scene.paint.Color;
import model.PlayerConfiguration;
import model.Race;

public class PlayerConfigurationTests {

	@Test
	public void testIsConfigured() {
		PlayerConfiguration config = new PlayerConfiguration();
		assertFalse(config.isConfigured.getValue());
		
		config.setName("Test");
		assertFalse(config.isConfigured.getValue());
		
		config.setRace(Race.Droid);
		assertFalse(config.isConfigured.getValue());
		
		config.setColor(Color.BLUE);
		assertTrue(config.isConfigured.getValue());
		
		config.setName("Tes");
		assertFalse(config.isConfigured.getValue());
		
		System.out.println("Test passed");
	}

}
