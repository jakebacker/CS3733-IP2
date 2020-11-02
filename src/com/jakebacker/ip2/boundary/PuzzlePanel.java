package com.jakebacker.ip2.boundary;

import com.jakebacker.ip2.model.Model;
import com.jakebacker.ip2.model.Tile;

import javax.swing.*;
import java.awt.*;

public class PuzzlePanel extends JPanel {

	Model model;
	JLabel[][] labels = new JLabel[3][3];

	public PuzzlePanel(Model m) {
		this.model = m;
	}

	public void addLabel(JLabel label, int x, int y) {
		labels[y][x] = label;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (model == null) { return; }

		int selX = -1;
		int selY = -1;

		Tile t = model.getSelectedTile();
		if (t != null) {
			selX = t.getX();
			selY = t.getY();
		}


		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				int value = model.getBoard().getTile(x, y).getValue();

				String lblStr = "";

				if (value >= 0) {
					lblStr = String.valueOf(value);
					if (y != selY && x != selX) {
						labels[y][x].setBackground(Model.NORMAL_COLOR);
					}
				} else {
					labels[y][x].setBackground(Model.EMPTY_COLOR);
				}

				labels[y][x].setText(lblStr);
			}
		}
	}
}
