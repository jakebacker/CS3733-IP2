package com.jakebacker.ip2.controller;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.model.Model;

import javax.swing.*;

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
		app.repaint();
	}
}
