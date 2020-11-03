package com.jakebacker.ip2.controller;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.model.Board;
import com.jakebacker.ip2.model.Model;
import com.jakebacker.ip2.model.MoveType;
import com.jakebacker.ip2.model.Tile;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestMoveTileController {

	@Test
	public void testMove() {
		Model model = new Model();
		Board board = new Board();

		board.addTile(new Tile(-1), 0, 0);
		board.addTile(new Tile(9), 1, 0);
		board.addTile(new Tile(-1), 2, 0);

		board.addTile(new Tile(-1), 0, 1);
		board.addTile(new Tile(27), 1, 1);
		board.addTile(new Tile(-1), 2, 1);

		board.addTile(new Tile(-1), 0, 2);
		board.addTile(new Tile(-1), 1, 2);
		board.addTile(new Tile(-1), 2, 2);

		model.setBoard(board);

		NumbersPuzzleApp app = new NumbersPuzzleApp(model);

		assertFalse(new MoveTileController(model, app).move(MoveType.Down));

		model.select(new JLabel("a"), 1, 0);

		assertTrue(new MoveTileController(model, app).move(MoveType.Down));
		assertTrue(model.isGameOver());
		assertEquals(Model.WIN_MESSAGE, app.getWinLabel().getText());

		model.select(new JLabel("b"), 1, 1);

		assertFalse(new MoveTileController(model, app).move(MoveType.Down));

		board.addTile(new Tile(-1), 0, 0);
		board.addTile(new Tile(9), 1, 0);
		board.addTile(new Tile(-1), 2, 0);

		board.addTile(new Tile(-1), 0, 1);
		board.addTile(new Tile(27), 1, 1);
		board.addTile(new Tile(-1), 2, 1);

		board.addTile(new Tile(-1), 0, 2);
		board.addTile(new Tile(-1), 1, 2);
		board.addTile(new Tile(-1), 2, 2);

		model.select(new JLabel("a"), 1, 1);
		model.setGameOver(false);
		assertTrue(new MoveTileController(model, app).move(MoveType.Up));
		assertTrue(model.isGameOver());
		assertEquals(Model.LOSE_MESSAGE, app.getWinLabel().getText());
	}
}
