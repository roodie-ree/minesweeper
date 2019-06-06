package de.vr.minelogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MineSweeperPlayGroundTest {
  private MineSweeperPlayGround playGround;

  @Before
  public void beforeEach() {
    playGround = new MineSweeperPlayGround();
  }

  @Test
  public void checkHeightAndWidth() {
    assertEquals(4, playGround.getHeight().intValue());
    assertEquals(4, playGround.getWidth().intValue());
  }

  @Test
  public void checkEmptyTile() {
    MineSweeperTile emptyTile = playGround.getTile(0, 3);
    assertFalse(emptyTile.isBomb());
    assertEquals(0, emptyTile.getBombCount().intValue());
  }

  @Test
  public void checkBombTile() {
    MineSweeperTile bombTile = playGround.getTile(1, 1);
    assertTrue(bombTile.isBomb());
    assertEquals(null, bombTile.getBombCount());
  }

  @Test
  public void checkTileWithThree() {
    MineSweeperTile threeTile = playGround.getTile(2, 1);
    assertFalse(threeTile.isBomb());
    assertEquals(3, threeTile.getBombCount().intValue());
  }

  @Test
  public void checkBombCount() {
    assertEquals(1, playGround.getTile(0, 0).getBombCount().intValue());
    assertEquals(1, playGround.getTile(0, 1).getBombCount().intValue());
    assertEquals(1, playGround.getTile(0, 2).getBombCount().intValue());
    assertEquals(0, playGround.getTile(0, 3).getBombCount().intValue());
    assertEquals(1, playGround.getTile(1, 0).getBombCount().intValue());
    assertEquals(null, playGround.getTile(1, 1).getBombCount());
    assertEquals(1, playGround.getTile(1, 2).getBombCount().intValue());
    assertEquals(0, playGround.getTile(1, 3).getBombCount().intValue());
    assertEquals(2, playGround.getTile(2, 0).getBombCount().intValue());
    assertEquals(3, playGround.getTile(2, 1).getBombCount().intValue());
    assertEquals(1, playGround.getTile(2, 2).getBombCount().intValue());
    assertEquals(1, playGround.getTile(2, 3).getBombCount().intValue());
    assertEquals(null, playGround.getTile(3, 0).getBombCount());
    assertEquals(2, playGround.getTile(3, 1).getBombCount().intValue());
    assertEquals(null, playGround.getTile(3, 2).getBombCount());
    assertEquals(1, playGround.getTile(3, 3).getBombCount().intValue());
  }

  @Test
  public void checkFlagTile() {
    assertFalse(playGround.getTile(1, 1).isFlagged());
    assertFalse(playGround.getTile(1, 1).isQuestion());

    playGround.flagTile(1, 1);
    assertTrue(playGround.getTile(1, 1).isFlagged());
    assertFalse(playGround.getTile(1, 1).isQuestion());

    playGround.flagTile(1, 1);
    assertFalse(playGround.getTile(1, 1).isFlagged());
    assertTrue(playGround.getTile(1, 1).isQuestion());

    playGround.flagTile(1, 1);
    assertFalse(playGround.getTile(1, 1).isFlagged());
    assertFalse(playGround.getTile(1, 1).isQuestion());
  }

  @Test
  public void checkRevealTile() {
    playGround.revealTile(0, 3);
    assertFalse(playGround.getTile(0, 2).isHidden());
    assertFalse(playGround.getTile(0, 3).isHidden());
    assertFalse(playGround.getTile(1, 2).isHidden());
    assertFalse(playGround.getTile(2, 2).isHidden());
    assertFalse(playGround.getTile(1, 3).isHidden());
    assertFalse(playGround.getTile(2, 3).isHidden());
  }

  @Test
  public void checkLostGame() {
    assertNull(playGround.gameEnd());
    playGround.revealTile(1, 1);
    assertFalse(playGround.gameEnd());
  }

  @Test
  public void checkWonGame() {
    assertNull(playGround.gameEnd());
    playGround.revealTile(0, 3);
    playGround.revealTile(0, 0);
    playGround.revealTile(0, 1);
    playGround.revealTile(1, 0);
    playGround.revealTile(2, 1);
    playGround.revealTile(3, 1);
    playGround.revealTile(3, 3);
    assertTrue(playGround.gameEnd());
  }
}
