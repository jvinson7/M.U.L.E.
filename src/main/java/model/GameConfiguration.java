package model;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GameConfiguration {

  private ObjectProperty<Difficulty> difficulty = new SimpleObjectProperty<Difficulty>();
  private ObjectProperty<Integer> numberOfPlayers = new SimpleObjectProperty<Integer>();

  public BooleanBinding isConfigured;

  public GameConfiguration() {
    isConfigured = Bindings.isNotNull(difficulty)
      .and(Bindings.isNotNull(numberOfPlayers));
  }

  @Override
  public String toString() {
    return super.toString()
      + " with " + numberOfPlayers.getValue()
      + " players and " + difficulty.getValue()
      + " difficulty.";
  }

  // Property accessors.
  
  // Number of Players
  public ObjectProperty<Integer> numberOfPlayersProperty() {
    return this.numberOfPlayers;
  }
  public Integer getNumberOfPlayers() {
    return this.numberOfPlayersProperty().getValue();
  }
  public void setNumberOfPlayers(final Integer numberOfPlayers) {
    this.numberOfPlayersProperty().set(numberOfPlayers);
  }

  // Difficulty
  public ObjectProperty<Difficulty> difficultyProperty() {
    return this.difficulty;
  }
  public Difficulty getDifficulty() {
    return this.difficultyProperty().getValue();
  }
  public void setDifficulty(final Difficulty difficulty) {
    this.difficultyProperty().set(difficulty);
  }
}
