package de.vr.minegui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.vr.minelogic.MineSweeperPlayGround;
import de.vr.minelogic.MineSweeperTile;
import de.vr.minesweeper.Zeit;

public class MineSweeperPlayGroundMap extends JFrame implements ActionListener, MouseListener{
	
	private JPanel playgroundPanel;
	private int height, width;
	private MineSweeperPlayGround playgroundLogic;
	private ImageIcon flagIcon = new ImageIcon("resources\\flag.svg");
	
	private int[][] tileArray;
	private JButton[][] tileButtonArray;
	
	Zeit zeit = new Zeit();
	
	public MineSweeperPlayGroundMap(JFrame frame) {
	    playgroundLogic = new MineSweeperPlayGround();
		this.height = playgroundLogic.getHeight();
		this.width = playgroundLogic.getWidth();
		tileArray = new int[height][width];
					
		playgroundPanel = new JPanel();        
        playgroundPanel.setLayout(new GridLayout(height, width));
        
        createPlayGround();
 
        frame.add(playgroundPanel);
    }
	
	private void createPlayGround() {
		tileButtonArray = new JButton[height][width];
        // Tiles werden dem Panel hinzugefügt        
        for (int i = 0; i < height; i++) {        	
        	for (int j = 0; j < width; j++) {
        		JButton tile = new JButton();
//        		tile.addActionListener(this);
        		tile.addMouseListener(this);
        		playgroundPanel.add(tile);
        		tileButtonArray[i][j] = tile;
        	}
        }               
	}
	
	public void actionPerformed (ActionEvent event) {
		Object source = event.getSource();
		for (int i = 0; i < tileButtonArray.length; i++) {
			for (int j = 0; j < tileButtonArray[i].length; j++) {
				if (source == tileButtonArray[i][j]) {
					System.out.println("Button: " + i + ", " + j);
					tileButtonArray[i][j].setEnabled(false);
					checkTile(i, j);
				}
			}
		}
	}
	
	public void checkTile(int x, int y) {
		MineSweeperTile tile = playgroundLogic.getTile(x, y);
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
						System.out.println("Left Button: " + i + ", " + j);
						zeit.zeitLaeuft();
						tileButtonArray[i][j].setEnabled(false);
						checkTile(i, j);
					}
					if (event.getButton() == MouseEvent.BUTTON3) {
						System.out.println("Right Button: " + i + ", " + j);
						tileButtonArray[i][j].setEnabled(false);
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
