package com.jakebacker.ip2.controller;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.model.Board;
import com.jakebacker.ip2.model.Model;
import com.jakebacker.ip2.model.MoveType;
import com.jakebacker.ip2.model.Tile;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestResetTileController {

	@Test
	public void testReset() {
		Model model = new Model();
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

		model.setBoard(board);

		board.save();

		board.addTile(new Tile(-1), 0, 0);
		board.addTile(new Tile(-1), 1, 0);
		board.addTile(new Tile(-1), 2, 0);

		board.addTile(new Tile(-1), 0, 1);
		board.addTile(new Tile(3), 1, 1);
		board.addTile(new Tile(-1), 2, 1);

		board.addTile(new Tile(-1), 0, 2);
		board.addTile(new Tile(-1), 1, 2);
		board.addTile(new Tile(-1), 2, 2);

		NumbersPuzzleApp app = new NumbersPuzzleApp(model);

		app.getWinLabel().setText("You win!");
		model.select(new JLabel("a"), 1, 1);
		model.setGameOver(true);

		new ResetTileController(model, app).reset();

		assertEquals(3, board.getTile(0, 0).value);
		assertEquals("", app.getWinLabel().getText());
		assertNull(model.getSelectedTile());
		assertFalse(model.isGameOver());
	}
}
