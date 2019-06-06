package de.vr.minelogic;

import java.util.Arrays;
import java.util.List;

class MineSweeperPlayGround {
  private Integer height;
  private Integer width;
  private Boolean gameState = null;
  private List<MineSweeperTile> tiles;

  public MineSweeperPlayGround() {
    height = 4;
    width = 4;
    tiles = Arrays.asList(
      new MineSweeperTile(), new MineSweeperTile(),
      new MineSweeperTile(), new MineSweeperTile().addBomb(),
      new MineSweeperTile(), new MineSweeperTile().addBomb(),
      new MineSweeperTile(), new MineSweeperTile(),
      new MineSweeperTile(), new MineSweeperTile(),
      new MineSweeperTile(), new MineSweeperTile().addBomb(),
      new MineSweeperTile(), new MineSweeperTile(),
      new MineSweeperTile(), new MineSweeperTile()
    );
    setBombCount();
  }

  public MineSweeperPlayGround(Integer height, Integer width, Integer bombs) {
    this.height = height;
    this.width = width;
    setBombCount();
  }

  private void setBombCount() {
    for (Integer x = 0; x < width; x += 1) {
      for (Integer y = 0; y < height; y += 1) {
        if (getTile(x, y).isBomb()) {
          addNearByBomb(x, y);
        }
      }
    }
  }

  private void addNearByBomb(Integer xIndex, Integer yIndex) {
    for (Integer x = xIndex - 1; x <= xIndex + 1; x +=1) {
      for (Integer y = yIndex - 1; y <= yIndex + 1 ; y += 1) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
          return;
        }
        MineSweeperTile tile = getTile(x, y);
        if (!tile.isBomb()) {
          tile.increaseBombCount();
        }
      }
    }
  }

  public Integer getHeight() {
    return height;
  }
  public Integer getWidth() {
    return width;
  }

  public MineSweeperTile getTile(Integer x, Integer y) {
    return tiles.get(x + y * width);
  }

  public void revealTile(Integer x, Integer y) {
    if (x < 0 || y < 0 || x >= width || y >= height) {
      return;
    }
    MineSweeperTile tile = getTile(x, y);
    if (!tile.isHidden()) {
      return;
    }
    tile.toggleHidden();
    if (tile.getBombCount() == null) {
      gameState = false;
    }
    if (tile.getBombCount() == 0) {
      for (Integer xIndex = x - 1; xIndex <= x + 1; xIndex +=1) {
        for (Integer yIndex = y - 1; yIndex <= y + 1 ; yIndex += 1) {
          revealTile(xIndex, yIndex);
        }
      }
    }
  }

  public void flagTile(Integer x, Integer y) {
    getTile(x, y).toggleFlaggedQuestion();
  }

  public Boolean gameEnd() {
    // true = won, false = lost, null = playing
    return gameState;
  }
}
