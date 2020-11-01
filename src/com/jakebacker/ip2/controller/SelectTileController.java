package com.jakebacker.ip2.controller;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.boundary.UpdateButtons;
import com.jakebacker.ip2.model.Model;
import com.jakebacker.ip2.model.MoveType;

import javax.swing.*;
import java.util.List;

public class SelectTileController {

	Model model;
	NumbersPuzzleApp app;

	public SelectTileController(Model m, NumbersPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void process(JLabel label, int x, int y) {
		model.clearSelectedTile();
		model.select(label, x, y);

		List<MoveType> moves = model.availableMoves();
		UpdateButtons.enableButtons(app, moves);

		app.repaint();
	}
}
