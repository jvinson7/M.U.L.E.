package model;

public class Plot {
  private int[] position;
  private final PlayerConfiguration owner;
  private boolean town = false;

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

  public void setTown() {
      town = true;
  }

  public boolean isTown() {
    return town;
  }
}
