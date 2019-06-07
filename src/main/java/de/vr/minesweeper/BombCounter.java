package de.vr.minesweeper;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

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
	
	    
