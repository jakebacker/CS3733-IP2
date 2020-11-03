package com.jakebacker.ip2.controller;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.boundary.UpdateButtons;
import com.jakebacker.ip2.model.Model;
import com.jakebacker.ip2.model.MoveType;

public class MoveTileController {

	Model model;
	NumbersPuzzleApp app;

	public MoveTileController(Model m, NumbersPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public boolean move(MoveType dir) {
		if (model.getSelectedTile() == null) { return false; }

		if (model.isGameOver()) {
			return false;
		}

		if (model.tryMove(dir)) {
			UpdateButtons.enableButtons(app, model.availableMoves());

			if (model.checkGameOver()) {
				// Game is over. Check for win
				model.setGameOver(true);
				if (model.checkGameWin()) {
					// Win!
					app.getWinLabel().setText(Model.WIN_MESSAGE);
				} else {
					// Lose!
					app.getWinLabel().setText(Model.LOSE_MESSAGE);
				}
			}

			app.repaint();
		}

		return true;
	}
}
