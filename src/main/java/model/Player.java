package model;

import javafx.scene.paint.Color;

public class Player {

	private String name;
	private Color color;
	private Race race;
	private int funds;

	public Player(String name, Color color, Race race) {
		this.name = name;
		this.color = color;
		this.race = race;
		this.funds = 600;
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

	public int getFunds() {
		return funds;
	}

	public boolean deductFunds(int amount) {
		if (funds - amount < 0) {
			return false;
		}
		funds -= amount;
		return true;
	}
}
