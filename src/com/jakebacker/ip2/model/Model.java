package com.jakebacker.ip2.model;

import javax.swing.*;
import java.awt.*;

public class Model {

	public static final Color NORMAL_COLOR = UIManager.getColor("Button.shadow");
	public static final Color SELECTED_COLOR = UIManager.getColor("Button.highlight");
	public static final Color EMPTY_COLOR = UIManager.getColor("Button.darkShadow");

	Board board;
	Tile selectedTile;
	JLabel selectedLabel;
	boolean gameOver = false;

	public Model() {

	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return this.board;
	}

	public void select(JLabel selectedLabel, int x, int y) {
		selectedTile = board.getTile(x, y);
		if (selectedLabel != null) {selectedLabel.setBackground(NORMAL_COLOR);}
		this.selectedLabel = selectedLabel;
		this.selectedLabel.setBackground(SELECTED_COLOR);
	}

	public Tile getSelectedTile() {
		return selectedTile;
	}

	public JLabel getSelectedLabel() {
		return selectedLabel;
	}

	public void clearSelectedTile() {
		selectedTile = null;
		if (selectedLabel != null) { selectedLabel.setBackground(NORMAL_COLOR); }
		selectedLabel = null;
	}

	public void setGameOver(boolean flag) {
		gameOver = flag;
	}

	public boolean isGameOver() {
		return gameOver;
	}
}
