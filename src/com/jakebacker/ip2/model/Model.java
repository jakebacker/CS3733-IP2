package com.jakebacker.ip2.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

	public static final Color NORMAL_COLOR = UIManager.getColor("Button.shadow");
	public static final Color SELECTED_COLOR = UIManager.getColor("Button.highlight");
	public static final Color EMPTY_COLOR = UIManager.getColor("Button.darkShadow");
	public static final Color WIN_COLOR = Color.GREEN;

	public static final String WIN_MESSAGE = "Congratulations! You win!";
	public static final String LOSE_MESSAGE = "You lost. Better luck next time!";

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
		Tile tempTile = board.getTile(x, y);
		if (tempTile.getValue() < 0) return; // Don't select an empty tile
		selectedTile = tempTile;
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

		if (tile.getValue() < 0) {
			return moves;
		}

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

	public boolean isIsolated(Tile t) {
		int x = t.getX();
		int y = t.getY();

		if (x-1 >= 0 && board.getTile(x-1, y).getValue() >= 0) return false;
		if (x+1 <= 2 && board.getTile(x+1, y).getValue() >= 0) return false;
		if (y-1 >= 0 && board.getTile(x, y-1).getValue() >= 0) return false;
		if (y+1 <= 2 && board.getTile(x, y+1).getValue() >= 0) return false;

		return true;
	}

	public boolean tryMove(MoveType dir) {
		if (selectedTile == null) { return false; }

		for (MoveType move : availableMoves()) {
			if (move == dir) {
				// The move is valid. Make it
				// Get the piece you are moving into, perform the math, update it's value, clear the current piece

				int x = selectedTile.x + dir.deltaX;
				int y = selectedTile.y + dir.deltaY;

				Tile other = board.getTile(x, y);

				int otherVal = other.value;
				int thisVal = selectedTile.value;

				switch (dir) {
					case Up:
						otherVal = otherVal * thisVal;
						break;
					case Right:
						otherVal = otherVal + thisVal;
						break;
					case Down:
						otherVal = otherVal / thisVal;
						break;
					case Left:
						otherVal = otherVal - thisVal;
						break;
				}

				other.setValue(otherVal);
				selectedTile.setValue(-1);
				clearSelectedTile();

				return true;
			}
		}

		return false;
	}

	public boolean checkGameOver() {

		boolean gameOver = true;

		for (int y=0; y<3; y++) {
			for (int x = 0; x < 3; x++) {
				Tile t = board.getTile(x, y);

				// Check for isolated tile
				if (isIsolated(t)) return true;

				List<MoveType> moves = availableMoves(t);
				if (moves.size() > 0) gameOver = false; // If there's a valid move anywhere, it's not over
			}
		}

		return gameOver;
	}

	public boolean checkGameWin() {
		boolean middleFilled = false;

		for (int y=0 ; y<3; y++) {
			for (int x=0; x<3; x++) {
				Tile t = board.getTile(x, y);

				if (t.getValue() > 0) {
					if (y == 1 && x == 1) {
						middleFilled = true;
					} else {
						middleFilled = false; // Double check to make sure that nothing else is filled
					}
				}
			}
		}

		return middleFilled;
	}
}
