package de.vr.minesweeper;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public void init() {

		GameOptionPanel gameOptionPanel = new GameOptionPanel();
		
		gameOptionPanel.init();
		
		this.add(gameOptionPanel, BorderLayout.PAGE_START);
		
		
		GamePanel game = new GamePanel();

		game.init();

		this.add(game,BorderLayout.CENTER);

		
		
		pack();
		setSize(1000, 1000);
		setVisible(true);

	}

}
