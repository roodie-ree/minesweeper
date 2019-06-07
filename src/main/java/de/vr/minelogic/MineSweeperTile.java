package de.vr.minelogic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MineSweeperTile extends JButton implements MouseListener {
  static final long serialVersionUID = 1;
  private Boolean hidden = true;
  private Boolean bomb = false;
  private Boolean flagged = false;
  private Boolean question = false;
  private Integer bombCount = 0;
  private Integer x;
  private Integer y;
  private MineSweeperPlayGround playGround;
	private ImageIcon flagIcon = new ImageIcon("src/main/resources/flag.svg");
	private ImageIcon redMineIcon = new ImageIcon("src/main/resources/mine2.svg");
	private ImageIcon greyMineIcon = new ImageIcon("src/main/resources/mine1.svg");
	private ImageIcon greyMineIcon2 = new ImageIcon("src/main/resources/mine3.svg");

  MineSweeperTile(Integer x, Integer y, MineSweeperPlayGround playGround) {
    this.x = x;
    this.y = y;
    this.playGround = playGround;
  }

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

  public void updateView() {
	  if(flagged){
		  setIcon(flagIcon);
	  }
	  if(question){
		  setText("?");
	  }
	  if(!(question && flagged)){
		  setIcon(null);
	  }
	  if(bomb){
		  setIcon(redMineIcon);
	  }
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

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {

  }

  @Override
  public void mousePressed(java.awt.event.MouseEvent e) {

  }

  @Override
  public void mouseReleased(java.awt.event.MouseEvent e) {
    if (MouseEvent.BUTTON1 == e.getButton()) {
      playGround.revealTile(x, y);
    } else if (MouseEvent.BUTTON3 == e.getButton()) {
      playGround.flagTile(x, y);
    }
  }

  @Override
  public void mouseEntered(java.awt.event.MouseEvent e) {

  }

  @Override
  public void mouseExited(java.awt.event.MouseEvent e) {

  }

}
