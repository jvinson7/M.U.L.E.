package model;

public class Plot {
  private int[] position;
  private PlayerConfiguration owner;

  public Plot(int x, int y) {
    position = new int[2];
    position[0] = x;
    position[1] = y;
  }

  public void setOwner(PlayerConfiguration owner) {
      this.owner = owner;
  }

  public PlayerConfiguration getOwner() {
      return owner;
  }
}
