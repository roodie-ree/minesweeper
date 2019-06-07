package de.vr.minelogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MineSweeperTileTest {
  private MineSweeperTile tile;

  @Before
  public void beforeEach() {
    MineSweeperPlayGround playGround = new MineSweeperPlayGround();
    MineSweeperTile tile = playGround.getTile(0, 3);
  }

  @Test
  public void checkHidden() {
    assertTrue(tile.isHidden());
    tile.toggleHidden();
    assertFalse(tile.isHidden());
  }

  @Test
  public void checkBomb() {
    assertFalse(tile.isBomb());
    tile.addBomb();
    assertTrue(tile.isBomb());
    assertNull(tile.getBombCount());
  }

  @Test
  public void checkFlag() {
    assertFalse(tile.isFlagged());
    tile.toggleFlaggedQuestion();
    assertTrue(tile.isFlagged());
    tile.toggleFlaggedQuestion();
    assertFalse(tile.isFlagged());
  }

  @Test
  public void checkQuestion() {
    assertFalse(tile.isQuestion());
    tile.toggleFlaggedQuestion();
    assertFalse(tile.isQuestion());
    tile.toggleFlaggedQuestion();
    assertTrue(tile.isQuestion());
  }

  @Test
  public void checkBombCount() {
    assertEquals(0, tile.getBombCount().intValue());
    tile.increaseBombCount();
    tile.increaseBombCount();
    assertEquals(2, tile.getBombCount().intValue());
    tile.increaseBombCount();
    assertEquals(3, tile.getBombCount().intValue());
  }
}
