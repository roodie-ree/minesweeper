package de.vr.minelogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import de.vr.minegui.MineSweeperPlayGroundMap;

public class MineSweeperPlayGround {
  private Integer height;
  private Integer width;
  private Integer bombs;
  private int flags;
  private Boolean gameState = null;
  protected List<MineSweeperTile> tiles;

  public MineSweeperPlayGround() {
    height = 4;
    width = 4;
    bombs = 3;
    tiles = Arrays.asList(
      new MineSweeperTile(0, 0, this),
      new MineSweeperTile(0, 1, this),
      new MineSweeperTile(0, 2, this),
      new MineSweeperTile(0, 3, this).addBomb(),
      new MineSweeperTile(1, 0, this),
      new MineSweeperTile(1, 1, this).addBomb(),
      new MineSweeperTile(1, 2, this),
      new MineSweeperTile(1, 3, this),
      new MineSweeperTile(2, 0, this),
      new MineSweeperTile(2, 1, this),
      new MineSweeperTile(2, 2, this),
      new MineSweeperTile(2, 3, this).addBomb(),
      new MineSweeperTile(3, 0, this),
      new MineSweeperTile(3, 1, this),
      new MineSweeperTile(3, 2, this),
      new MineSweeperTile(3, 3, this)
    );
    setBombCount();
  }

  public MineSweeperPlayGround(Integer height, Integer width, Integer bombs) {
    this.height = height;
    this.width = width;
    this.bombs = bombs;
    tiles = new ArrayList<MineSweeperTile>();
    for (int x = 0; x < width; x += 1) {
    	for (int y = 0; y < height; y += 1) {
    		tiles.add(new MineSweeperTile(x, y, this));
    	}
      
    }
    Random random = new Random();
    while (bombs > 0) {
      Integer bomb = random.nextInt(tiles.size());
      MineSweeperTile tile = tiles.get(bomb);
      if (!tile.isBomb()) {
        tile.addBomb();
        bombs -= 1;
      }
    }

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
          continue;
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

  public Integer getBombs() {
    return bombs;
  }

  public Integer getBombFlagCounter() {
    return bombs - flags;
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
    tile.updateView();
    if (tile.isBomb()) {
      gameState = false;

    } else if (tile.getBombCount() == 0) {
      for (Integer xIndex = x - 1; xIndex <= x + 1; xIndex +=1) {
        for (Integer yIndex = y - 1; yIndex <= y + 1 ; yIndex += 1) {
          revealTile(xIndex, yIndex);
        }
      }
    }
  }

  public void flagTile(Integer x, Integer y) {
    MineSweeperTile tile = getTile(x, y);
    tile.toggleFlaggedQuestion();
    if (tile.isFlagged()) {
      flags += 1;
    } else {
      flags -= 1;
    }
    tile.updateView();
  }

  private Long countOpenTiles() {
    return tiles.stream()
      .filter(tile -> !tile.isHidden())
      .count();
  }

  public Boolean gameEnd() {
    // true = won, false = lost, null = playing
    Long openTiles = countOpenTiles();
    if (bombs + openTiles == tiles.size()) {
      gameState = true;
    }
    return gameState;
  }
}
