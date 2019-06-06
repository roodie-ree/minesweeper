package de.vr.minelogic;

class MineSweeperPlayGround {
  public MineSweeperPlayGround (Integer height, Integer width) {

  }

  public Integer getHeight() {
    return 9;
  }
  public Integer getWidth() {
    return 9;
  }

  public MineSweeperTile getTile(Integer x, Integer y) {
    return new MineSweeperTile();
  }

  public void revealTile(Integer x, Integer y) {

  }

  public void flagTile(Integer x, Integer y) {

  }

  public Boolean gameEnd() {
    // true = won, false = lost, null = playing
    return null;
  }
}
