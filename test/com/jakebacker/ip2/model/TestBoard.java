package com.jakebacker.ip2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoard {

	@Test
	public void testAdd() {
		Board board = new Board();
		Tile tile = new Tile(3);

		board.addTile(tile, 2, 1);

		assertEquals(tile, board.getTile(2, 1));
		assertEquals(2, tile.getX());
		assertEquals(1, tile.getY());
	}

	@Test
	public void testSave() {
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

		board.save();

		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				Tile actual = board.tiles[y][x];
				Tile copy = board.tilesOriginal[y][x];

				assertEquals(actual.value, copy.value);
				assertEquals(actual.x, copy.x);
				assertEquals(actual.y, copy.y);
			}
		}
	}

	@Test
	public void testReset() {
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

		board.save();

		board.addTile(new Tile(100), 0, 0);

		board.reset();

		Tile t = board.tiles[0][0];

		assertEquals(3, t.value);
		assertEquals(0, t.x);
		assertEquals(0, t.y);
	}
}
