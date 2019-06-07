package de.vr.minesweeper;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import de.vr.minelogic.MineSweeperPlayGround;

public class Zeit {
	
	MineSweeperPlayGround mineSweeperPlayGround = new MineSweeperPlayGround();
	
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
	
	public void zeitLaeuft() {
		Zeit.timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mineSweeperPlayGround.gameEnd() == null) {
					Zeit.counterValue++;
					Zeit.label.setText(String.valueOf(counterValue));
				} 
				if (Zeit.counterValue == 999) {
					Zeit.timer.stop();
				}
			}
		});
		timer.start();
	}
	
	public void zeitStoppen() {
		Zeit.timer.stop();
		Zeit.counterValue = 0;
		Zeit.label.setText(String.valueOf(counterValue));
	}
}