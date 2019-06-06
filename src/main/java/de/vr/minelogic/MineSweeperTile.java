package de.vr.minelogic;

class MineSweeperTile {
  private Boolean hidden = true;
  private Boolean bomb = false;
  private Boolean flagged = false;
  private Boolean question = false;
  private Integer bombCount = 0;

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

  protected void toggleHidden() {
    this.hidden = !this.hidden;
  }

  protected MineSweeperTile addBomb() {
    this.bomb = true;
    this.bombCount = null;
    return this;
  }

  protected void toggleFlaggedQuestion() {
    if (!(flagged || question)) {
      flagged = true;
    } else if (flagged) {
      flagged = false;
      question = true;
    } else {
      question = false;
    }
  }

  protected void increaseBombCount() {
    bombCount += 1;
  }

  @Override
  public String toString() {
    return "{" +
      " hidden='" + isHidden() + "'" +
      ", bomb='" + isBomb() + "'" +
      ", flagged='" + isFlagged() + "'" +
      ", question='" + isQuestion() + "'" +
      ", bombCount='" + getBombCount() + "'" +
      "}";
  }

}
