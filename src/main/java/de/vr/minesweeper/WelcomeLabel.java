package de.vr.minesweeper;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

public class WelcomeLabel extends JLabel {
	public static JLabel label;

	public Component createWelcomeLabel() {
		label = new JLabel();
		label.setFont(label.getFont().deriveFont(64f));
		label.setForeground(Color.black);
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setText("Willkommen bei Minesweeper");
		return label;
	}
	
	public Component createHighscoreLabel() {
		label = new JLabel();
		label.setFont(label.getFont().deriveFont(64f));
		label.setForeground(Color.black);
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setText("Die Besten der Besten:");
		return label;
	}
}
