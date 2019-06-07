package de.vr.minegui;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.vr.minelogic.MineSweeperPlayGround;
import de.vr.minesweeper.Zeit;

public class MineSweeperPlayGroundMap extends JPanel implements MouseListener{
	
	private JPanel playgroundPanel;
	private int height, width;
	private MineSweeperPlayGround playgroundLogic;
	private ImageIcon flagIcon = new ImageIcon("src/main/resources/flag.svg");	
	
	private JButton[][] tileButtonArray;
	
	// damit der Timer Start nur beim ersten linken Mausclick ausgelöst wird
	private boolean firstClick = false;
	
	Zeit zeit = new Zeit();
	
	public void init() {
	    playgroundLogic = new MineSweeperPlayGround();
		this.height = playgroundLogic.getHeight();
		this.width = playgroundLogic.getWidth();					
		       
        setLayout(new GridLayout(height, width));
        createPlayGround();
	}
	
	private void createPlayGround() {
		tileButtonArray = new JButton[height][width];
        // Tiles werden dem Panel hinzugefügt        
        for (int i = 0; i < height; i++) {        	
        	for (int j = 0; j < width; j++) {
        		JButton tile = new JButton();
        		tile.setFont(tile.getFont().deriveFont(64f));
        		tile.addMouseListener(this);
        		this.add(tile);
        		tileButtonArray[i][j] = tile;
        	}
        }               
	}
	
	public void revealTile(int x, int y) {
		tileButtonArray[x][y].setEnabled(false);
		playgroundLogic.revealTile(x, y);
		
		for (int i = 0; i < tileButtonArray.length; i++) {
			for (int j = 0; j < tileButtonArray[i].length; j++) {
				if (!playgroundLogic.getTile(i, j).isHidden()) {
					tileButtonArray[i][j].setEnabled(false);
					if (playgroundLogic.getTile(i, j).isBomb()) {
						tileButtonArray[i][j].setIcon(flagIcon);
					}
					else {
						tileButtonArray[i][j].setText(playgroundLogic.getTile(i, j).getBombCount().toString());
					}
				} 

			}
		}
	}
	
	public void flagTile(int x, int y) {
		tileButtonArray[x][y].setIcon(flagIcon);
		playgroundLogic.flagTile(x, y);
	}
	
	@Override
	public void mouseClicked (MouseEvent event) {
		Object source = event.getSource();
		for (int i = 0; i < tileButtonArray.length; i++) {
			for (int j = 0; j < tileButtonArray[i].length; j++) {
				if (source == tileButtonArray[i][j]) {
					if (event.getButton() == MouseEvent.BUTTON1) {
						if (!firstClick) {
							zeit.zeitLaeuft();
							firstClick = true;
						}
						System.out.println("Left Button: " + i + ", " + j);
						tileButtonArray[i][j].setEnabled(false);
						revealTile(i, j);
					}
					if (event.getButton() == MouseEvent.BUTTON3) {
						System.out.println("Right Button: " + i + ", " + j);
						tileButtonArray[i][j].setIcon(flagIcon);
						flagTile(i, j);
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
