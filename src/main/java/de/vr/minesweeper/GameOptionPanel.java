package de.vr.minesweeper;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GameOptionPanel extends JPanel {
	Buttons buttons = new Buttons();
	Zeit zeit = new Zeit();
	BombCounter bombs=new BombCounter();
	
	public void init() {
		
		Component buttonSmily = buttons.createSmilyButton();
		Component timeLabel = zeit.createTimeLabel();
		Component bomben= bombs.createBombCounter();
		GridLayout experimentLayout = new GridLayout(0, 3);
		setLayout(experimentLayout);
		add(bomben, BorderLayout.LINE_START);
		add(buttonSmily, BorderLayout.CENTER);
		add(timeLabel, BorderLayout.PAGE_END);
	    
	    
	}
}
