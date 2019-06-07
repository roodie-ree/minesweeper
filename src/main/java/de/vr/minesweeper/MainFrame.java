package de.vr.minesweeper;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import de.vr.minegui.MineSweeperPlayGroundMap;

public class MainFrame extends JFrame {

	public void init() {

		GameOptionPanel gameOptionPanel = new GameOptionPanel();
		
		gameOptionPanel.init();
		
		this.add(gameOptionPanel, BorderLayout.PAGE_START);
		
		MineSweeperPlayGroundMap playgroundmap = new MineSweeperPlayGroundMap();
		
		playgroundmap.init();
		
		this.add(playgroundmap, BorderLayout.CENTER);		
		
		pack();
		setSize(1000, 1000);
		setVisible(true);
	}

}
