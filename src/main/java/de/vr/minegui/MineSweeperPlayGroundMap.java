package de.vr.minegui;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.vr.minelogic.MineSweeperPlayGround;
import de.vr.minesweeper.Buttons;
import de.vr.minesweeper.Zeit;

public class MineSweeperPlayGroundMap extends JPanel implements MouseListener{
	
	private JPanel playgroundPanel;
	private int height, width;
	private MineSweeperPlayGround playgroundLogic;
	private ImageIcon flagIcon = new ImageIcon("src/main/resources/flag.svg");
	private ImageIcon redMineIcon = new ImageIcon("src/main/resources/mine2.svg");
	private ImageIcon greyMineIcon = new ImageIcon("src/main/resources/mine1.svg");
	private ImageIcon greyMineRedXIcon = new ImageIcon("src/main/resources/mine3.svg");
	
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
		playgroundLogic.revealTile(x, y);		
		for (int i = 0; i < tileButtonArray.length; i++) {
			for (int j = 0; j < tileButtonArray[i].length; j++) {
				if (!playgroundLogic.getTile(i, j).isHidden()) {					
					if (playgroundLogic.getTile(i, j).isBomb()) {						
						tileButtonArray[i][j].setIcon(redMineIcon);	
						gameOver();
					}
					else {
						tileButtonArray[i][j].setText(playgroundLogic.getTile(i, j).getBombCount().toString());
						tileButtonArray[i][j].setEnabled(false);
					}
				} 
			}
		}
	}
	
	public void flagTile(int x, int y) {
		playgroundLogic.flagTile(x, y);
		JButton button = tileButtonArray[x][y];
		if(playgroundLogic.getTile(x, y).isFlagged()) {
			button.setIcon(flagIcon);
		} else if (playgroundLogic.getTile(x, y).isQuestion()) {
			button.setIcon(null);
			button.setText("?");
		} else {
			button.setIcon(null);
			button.setText("");
		}
	}
	
	@Override
	public void mouseClicked (MouseEvent event) {
		Object source = event.getSource();
		for (int i = 0; i < tileButtonArray.length; i++) {
			for (int j = 0; j < tileButtonArray[i].length; j++) {
				if (source == tileButtonArray[i][j]) {
					if (!tileButtonArray[i][j].isEnabled()){
						return;
					}
					else{
					if (event.getButton() == MouseEvent.BUTTON1) {
						if (!firstClick) {
							zeit.zeitLaeuft();
							firstClick = true;
						}
						System.out.println("Left Button: " + i + ", " + j);
						System.out.println(playgroundLogic.getTile(i, j).isFlagged());
						if (playgroundLogic.getTile(i, j).isFlagged() || playgroundLogic.getTile(i, j).isQuestion()) {
							return;
						} else {							
							revealTile(i, j);
						}
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
	}
	
	public void disableTiles(){
		for (int i = 0; i < tileButtonArray.length; i++) {
			for (int j = 0; j < tileButtonArray[i].length; j++) {		
				if (playgroundLogic.getTile(i, j).isBomb()) {					
					if (playgroundLogic.getTile(i, j).isHidden()) {						
						tileButtonArray[i][j].setIcon(redMineIcon);	
					}
				} 
				if (playgroundLogic.getTile(i, j).isFlagged() || playgroundLogic.getTile(i, j).isQuestion()) {					
					if (playgroundLogic.getTile(i, j).isBomb()) {						
						tileButtonArray[i][j].setIcon(redMineIcon);	
					}
					else {
						tileButtonArray[i][j].setIcon(greyMineRedXIcon);
					}
				}
				tileButtonArray[i][j].setEnabled(false);
			}
		}
	}
	
	public void gameOver(){
		Buttons.changeIconDead();
		disableTiles();
		Zeit.timer.stop();
	}
	public void gameWon(){
		Buttons.changeIconWinner();
		disableTiles();
		Zeit.timer.stop();
	}	
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(playgroundLogic.gameEnd()==null){
			Buttons.changeIconShocked();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(playgroundLogic.gameEnd()==null){
			Buttons.changeIconSmily();
		}

	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
