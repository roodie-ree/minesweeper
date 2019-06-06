package de.vr.minelogic;

class MineSweeperTile {
  private Boolean hidden = true;
  private Boolean bomb = false;
  private Boolean flagged = false;
  private Boolean question = false;
  private Integer bombCount = null;

  public Boolean isHidden() {
    return this.hidden;
  }

  public Boolean isBomb() {
    return this.bomb;
  }

  public Boolean isFlagged() {
    return this.flagged;
  }

  public Boolean isQuestion() {
    return this.question;
  }

  public Integer getBombCount() {
    return this.bombCount;
  }
}
