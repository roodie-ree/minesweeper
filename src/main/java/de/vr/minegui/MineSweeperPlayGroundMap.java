package de.vr.minegui;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.vr.minelogic.MineSweeperPlayGround;
import de.vr.minelogic.MineSweeperTile;
import de.vr.minesweeper.Buttons;
import de.vr.minesweeper.Zeit;

public class MineSweeperPlayGroundMap extends JPanel {

	private JPanel playgroundPanel;
	private int height, width;
	private MineSweeperPlayGround playground;
	private ImageIcon flagIcon = new ImageIcon("src/main/resources/flag.svg");
	private ImageIcon redMineIcon = new ImageIcon("src/main/resources/mine2.svg");
	private ImageIcon greyMineRedXIcon = new ImageIcon("src/main/resources/mine3.svg");

	// damit der Timer Start nur beim ersten linken Mausclick ausgelöst wird
	private boolean firstClick = false;

	Zeit zeit = new Zeit();

	public void init() {
	    playground = new MineSweeperPlayGround(5, 5, 1);
		this.height = playground.getHeight();
		this.width = playground.getWidth();
		for (MineSweeperTile tile : playground.getTiles()) {
			this.add(tile);
		}
    setLayout(new GridLayout(height, width));
	}

	public void gameOver(){
		Buttons.changeIconDead();
		Zeit.timer.stop();
	}
	public void gameWon(){
		Buttons.changeIconWinner();
		Zeit.timer.stop();
	}
}
