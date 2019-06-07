package de.vr.minesweeper;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import de.vr.minelogic.MineSweeperTile;

public class BombCounter extends JFrame {
	public static JLabel label;
	
	public Component createBombCounter(){
		MineSweeperTile bombcount=new MineSweeperTile();
		Integer bombamount = bombcount.getBombCount();
		label = new JLabel();
		label.setFont(label.getFont().deriveFont(64f));
		label.setForeground(Color.red);
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setText(String.valueOf(bombamount));
	    return label;
	}
}
	
	    
