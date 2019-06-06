package de.vr.minesweeper;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GameOptionPanel extends JPanel {
	Buttons buttons = new Buttons();
	Zeit zeit = new Zeit();

	public void init() {

		Component buttonSmily = buttons.createSmilyButton();
		Component buttonshocked = buttons.createShockedButton();
		Component buttonDead = buttons.createDeadButton();
		Component timeLabel = zeit.createTimeLabel();
		// panel.add(buttonSmily);
		// buttonSmily.setbounds();
		// button.setPreferredSize(new Dimension(200, 100));
		GridLayout experimentLayout = new GridLayout(0, 3);
		setLayout(experimentLayout);
		add(buttonSmily, BorderLayout.LINE_START);
		add(buttonshocked, BorderLayout.CENTER);
		add(timeLabel, BorderLayout.PAGE_END);

	}
}
