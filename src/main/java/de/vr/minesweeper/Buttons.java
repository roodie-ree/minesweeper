package de.vr.minesweeper;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Buttons {
	
	
	public Component createSmilyButton(){
		JButton button = new JButton(new ImageIcon("src/main/resources/icons8-glücklich-48.png"));
	    button.setSize(500,500);
	    return button;
	}
	
	public Component createShockedButton(){
		JButton button = new JButton(new ImageIcon("src/main/resources/icons8-überrascht-16.png"));
	    button.setSize(500,500);
	    return button;
	}	
	
	public Component createDeadButton(){
		JButton button = new JButton(new ImageIcon("src/main/resources/icons8-glücklich-48.png"));
	    button.setSize(500,500);
	    return button;
	}	
	
    public static void main(String[] args)
    {
        
        //boolean selected=false;
		//button.setSelected(selected);        
    }
}
