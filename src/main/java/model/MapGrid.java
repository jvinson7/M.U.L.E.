package models;
import model.Plot;
import model.PlayerConfiguration;

public class MapGrid {
  private Plot[][] grid;

  public MapGrid(int height, int width) {
    grid = new Plot[height][width];
  }

}
