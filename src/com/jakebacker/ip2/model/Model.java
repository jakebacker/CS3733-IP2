package com.jakebacker.ip2.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

	public List<MoveType> availableMoves() {
		if (selectedTile == null) return new ArrayList<>(); // No valid moves

		return availableMoves(selectedTile);
	}

	public List<MoveType> availableMoves(Tile tile) {
		// For a move to be valid, it must be on the board and must result in a non-negative integer

		ArrayList<MoveType> moves = new ArrayList<>();

		int tileX = tile.getX();
		int tileY = tile.getY();

		// Left?
		if (tileX > 0) {
			Tile next = board.getTile(tileX-1, tileY);

			if (next.getValue() >= 0 && next.getValue() - tile.getValue() >= 0) {
				moves.add(MoveType.Left);
			}
		}

		// Right?
		if (tileX < 2) {
			Tile next = board.getTile(tileX+1, tileY);

			if (next.getValue() >= 0) {
				moves.add(MoveType.Right);
			}
		}

		// Up?
		if (tileY > 0) {
			Tile next = board.getTile(tileX, tileY-1);

			if (next.getValue() >= 0) {
				moves.add(MoveType.Up);
			}
		}

		if (tileY < 2) {
			Tile next = board.getTile(tileX, tileY+1);

			if (next.getValue() >= 0 && next.getValue() % tile.getValue() == 0) {
				moves.add(MoveType.Down);
			}
		}

		return moves;
	}
}
