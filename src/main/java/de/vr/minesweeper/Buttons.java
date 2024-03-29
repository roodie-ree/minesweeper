package de.vr.minesweeper;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Buttons {
	static JButton button = new JButton(new ImageIcon("src/main/resources/icons8-glücklich-48.png"));;
	private static ImageIcon shocked=new ImageIcon("src/main/resources/icons8-überrascht-16.png");
	private static ImageIcon dead=new ImageIcon("src/main/resources/dead.png");
	private static ImageIcon smily=new ImageIcon("src/main/resources/icons8-glücklich-48.png");
	private static ImageIcon winner=new ImageIcon("src/main/resources/cool.png");
	
	public Component createSmilyButton(){
	    button.setSize(500,500);
	    return button;
	}
	
	
//	public Component createShockedButton(){
//		JButton button = new JButton(new ImageIcon("src/main/resources/icons8-überrascht-16.png"));
//	    button.setSize(500,500);
//	    return button;
//	}	
//	
//	public Component createDeadButton(){
//		JButton button = new JButton(new ImageIcon("src/main/resources/icons8-glücklich-48.png"));
//	    button.setSize(500,500);
//	    return button;
//	}	
	
	public static void changeIconShocked (){
		button.setIcon(shocked);
	}

	
	public static void changeIconDead (){
		button.setIcon(dead);
	}
	
	public static void changeIconSmily (){
		button.setIcon(smily);
	}
	
	public static void changeIconWinner (){
		button.setIcon(winner);
	}	
	
	
}
