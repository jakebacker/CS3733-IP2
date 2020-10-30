package com.jakebacker.ip2.model;

public class Model {
	Board board;
	Tile selectedTile;
	boolean gameOver = false;

	public Model() {

	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
