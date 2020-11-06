package com.jakebacker.ip2.controller;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;

import javax.swing.*;

public class ExitController {
	NumbersPuzzleApp app;

	public ExitController(NumbersPuzzleApp app) {
		this.app = app;
	}

	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you wish to exit application?");
		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}

}

