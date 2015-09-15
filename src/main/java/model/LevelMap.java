package model;

import com.sun.javafx.collections.ImmutableObservableList;
import javafx.collections.ObservableList;

public enum LevelMap {
  Earth,
  Moon,
  Mars;

  @Override
  public String toString() {
    return this.name();
  }

  public static ObservableList<LevelMap> allLevelMaps = new ImmutableObservableList<LevelMap>(LevelMap.values());
}
