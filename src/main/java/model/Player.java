package model;

import javafx.scene.paint.Color;

public class Player {

	private String name;
	private Color color;
	private Race race;

	public Player(String name, Color color, Race race) {
		this.name = name;
		this.color = color;
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public Race getRace() {
		return race;
	}
}
