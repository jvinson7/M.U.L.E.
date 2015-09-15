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

  private ObjectProperty<LevelMap> levelMap = new SimpleObjectProperty<LevelMap>();

  public BooleanBinding isConfigured;

  public GameConfiguration() {
    isConfigured = Bindings.isNotNull(difficulty)
      .and(Bindings.isNotNull(numberOfPlayers))
      .and(Bindings.isNotNull(levelMap));
  }

  @Override
  public String toString() {
    return super.toString()
      + " with " + numberOfPlayers.getValue()
      + " players, " + difficulty.getValue()
      + " difficulty, and " + levelMap.getValue()
      + " level map.";
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

  // LevelMap
  public ObjectProperty<LevelMap> levelMapProperty() {
    return this.levelMap;
  }
  public LevelMap getLevelMap() {
    return this.levelMapProperty().getValue();
  }
  public void setLevelMap(final LevelMap levelMap) {
    this.levelMapProperty().set(levelMap);
  }
}
