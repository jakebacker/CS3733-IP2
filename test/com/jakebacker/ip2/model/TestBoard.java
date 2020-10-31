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
}
