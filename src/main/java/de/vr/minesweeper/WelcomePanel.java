package de.vr.minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
	
	Buttons buttons = new Buttons();
	WelcomeLabel willkommen = new WelcomeLabel();
	BombCounter bombs = new BombCounter();
	
	public void init(JButton button) {
		Component welcomeLabel = willkommen.createWelcomeLabel();
		Component startButton = button;
		Component highscoreLabel = willkommen.createHighscoreLabel();
		GridLayout experimentLayout = new GridLayout(3, 0);
		setLayout(experimentLayout);
		add(welcomeLabel, BorderLayout.CENTER);
		add(startButton, BorderLayout.CENTER);
		add(highscoreLabel, BorderLayout.CENTER);
	}
	
}
