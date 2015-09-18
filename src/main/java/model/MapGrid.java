package models;
import model.Plot;
import model.PlayerConfiguration;

public class MapGrid {
  private Plot[][] grid;
  private PlayerConfiguration owner;

  public MapGrid(int height, int width, PlayerConfiguration owner) {
    grid = new Plot[height][width];
    this.owner = owner;
  }
}
