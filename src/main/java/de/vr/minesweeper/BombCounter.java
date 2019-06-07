package de.vr.minesweeper;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BombCounter extends JFrame {
	public static JLabel label;

	public Component createBombCounter(){
		Integer bombAmount = 0;
		label = new JLabel();
		label.setFont(label.getFont().deriveFont(64f));
		label.setForeground(Color.red);
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setText(String.valueOf(bombAmount));
	    return label;
	}
}
