package de.vr.mineweb;

public class HighScore {
  private Integer score;
  private String name;

  public HighScore(Integer score, String name) {
    this.score = score;
    this.name = name;
  }

  public Integer getScore() {
    return this.score;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "{" +
      " score='" + getScore() + "'" +
      ", name='" + getName() + "'" +
      "}";
  }
}
