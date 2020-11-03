package com.jakebacker.ip2.controller;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.boundary.UpdateButtons;
import com.jakebacker.ip2.model.Model;

public class ResetTileController {

	Model model;
	NumbersPuzzleApp app;

	public ResetTileController(Model m, NumbersPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void reset() {
		model.getBoard().reset();
		app.getWinLabel().setText("");
		model.clearSelectedTile();
		model.setGameOver(false);
		UpdateButtons.enableButtons(app, model.availableMoves());

		app.repaint();
	}
}
