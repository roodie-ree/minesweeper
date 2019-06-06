package de.vr.minegui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import de.vr.minelogic.MineSweeperPlayGround;
import de.vr.minelogic.MineSweeperTile;;

public class MineSweeperWindow {
	
	private MineSweeperPlayGroundMap playgroundPanel;
	private int height, width;
	private MineSweeperPlayGround playgroundLogic;
	
	public MineSweeperWindow() {	
		JFrame mineSweeperFrame = new JFrame();
		mineSweeperFrame.setTitle("MineSweeper");
					
		playgroundPanel = new MineSweeperPlayGroundMap(mineSweeperFrame);        
 
        mineSweeperFrame.setSize(1000, 1000); 
        mineSweeperFrame.setVisible(true);
	}
	

}
