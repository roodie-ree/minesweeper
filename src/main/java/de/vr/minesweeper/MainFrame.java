package de.vr.minesweeper;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.vr.minegui.MineSweeperPlayGroundMap;

public class MainFrame extends JFrame {

	WelcomePanel welcome = new WelcomePanel();

	GameOptionPanel gameOptionPanel = new GameOptionPanel();
	
	MineSweeperPlayGroundMap playgroundmap = new MineSweeperPlayGroundMap();
	
	Zeit zeit = new Zeit();

	public void init() {

		JButton buttonstart = new JButton("Start");
		buttonstart.setSize(500,500);
		buttonstart.setFont(buttonstart.getFont().deriveFont(64f));
	    	
		buttonstart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Start");
				addnew();
			}
		});
		
		welcome.init(buttonstart);

		this.add(welcome, BorderLayout.CENTER);

		welcome.buttons.button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Neustart");
				removeField();
				addGameField();
				zeit.zeitStoppen();
			}
		});
		
		pack();
		setSize(1000, 1000);
		setVisible(true);
	}

	public void addnew() {
		this.remove(welcome);
		
		playgroundmap.init();
		gameOptionPanel.init();
		this.add(gameOptionPanel, BorderLayout.PAGE_START);
		this.add(playgroundmap, BorderLayout.CENTER);

		revalidate();
		repaint();
	}
	
	public void removeField(){
		this.remove(playgroundmap);
		revalidate();
		repaint();
	}
	
	public void addGameField() {
		this.playgroundmap = new MineSweeperPlayGroundMap();
		playgroundmap.init();
		this.add(playgroundmap);
		revalidate();
		repaint();
	}
	

}
