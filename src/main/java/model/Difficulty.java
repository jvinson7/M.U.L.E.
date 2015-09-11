package model;

import com.sun.javafx.collections.ImmutableObservableList;
import javafx.collections.ObservableList;

public enum Difficulty {
  Easy,
  Medium,
  Hard;

  @Override
  public String toString() {
    return this.name();
  }

  public static ObservableList<Difficulty> allDifficulties = new ImmutableObservableList<Difficulty>(Difficulty.values());
}
