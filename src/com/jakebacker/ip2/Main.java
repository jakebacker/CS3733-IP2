package com.jakebacker.ip2;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.model.Board;
import com.jakebacker.ip2.model.Model;
import com.jakebacker.ip2.model.Tile;

public class Main {
	public static void main(String[] args) {

		Model m = new Model();

		Board board = new Board();

		board.addTile(new Tile(3), 0, 0);
		board.addTile(new Tile(6), 1, 0);
		board.addTile(new Tile(4), 2, 0);

		board.addTile(new Tile(1), 0, 1);
		board.addTile(new Tile(7), 1, 1);
		board.addTile(new Tile(9), 2, 1);

		board.addTile(new Tile(2), 0, 2);
		board.addTile(new Tile(5), 1, 2);
		board.addTile(new Tile(8), 2, 2);

		m.setBoard(board);

		NumbersPuzzleApp app = new NumbersPuzzleApp(m);

		app.setVisible(true);
	}
}
