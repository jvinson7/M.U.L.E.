package model;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

/**
 * The PlayerConfiguration stores infrequently changed player settings.
 * Use the isConfigured binding
 * @author Kevin Randrup
 */
public class PlayerConfiguration {
	
	private StringProperty name = new SimpleStringProperty();
	private ObjectProperty<Color> color = new SimpleObjectProperty<Color>();
	private ObjectProperty<Race> race = new SimpleObjectProperty<Race>();

	public BooleanBinding isConfigured;

	public PlayerConfiguration() {
		BooleanBinding colorAndRace = Bindings.isNotNull(color).and(Bindings.isNotNull(race));
		BooleanBinding validName = Bindings.lessThanOrEqual(4, name.length());
		isConfigured = colorAndRace.and(validName);
	}
	
	@Override
	public String toString() {
		return super.toString()
			+ " with name " + name.getValue()
			+ ", color " + color.getValue()
			+ ", and race " + race.getValue();
	}
	
	//AutoGenerated property accessors

	//Name
	public StringProperty nameProperty() {
		return this.name;
	}
	public java.lang.String getName() {
		return this.nameProperty().get();
	}
	public void setName(final java.lang.String name) {
		this.nameProperty().set(name);
	}
	
	//Color
	public ObjectProperty<Color> colorProperty() {
		return this.color;
	}
	public javafx.scene.paint.Color getColor() {
		return this.colorProperty().get();
	}
	public void setColor(final javafx.scene.paint.Color color) {
		this.colorProperty().set(color);
	}
	

	//Race
	public ObjectProperty<Race> raceProperty() {
		return this.race;
	}
	public model.Race getRace() {
		return this.raceProperty().get();
	}
	public void setRace(final model.Race race) {
		this.raceProperty().set(race);
	}
}
