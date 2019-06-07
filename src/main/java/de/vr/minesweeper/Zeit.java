package de.vr.minesweeper;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Zeit {

	public static int counterValue = 0;
	public static Timer timer;
	public static JLabel label;
	
	public Component createTimeLabel(){
		label = new JLabel();
		label.setFont(label.getFont().deriveFont(64f));
		label.setForeground(Color.red);
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setText(String.valueOf(counterValue));
	    return label;
	}
	
	//Methode zum starten des Timers, muss noch mit zugehöriger action eingebunden werden
	public void zeitLaeuft() {

		Zeit.timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Zeit.counterValue++;

				Zeit.label.setText(String.valueOf(counterValue));

				if (Zeit.counterValue == 999) {
					Zeit.timer.stop();
				}
			}
		});

		timer.start();
	}
}