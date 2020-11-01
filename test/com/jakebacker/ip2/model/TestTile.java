package com.jakebacker.ip2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTile {

	@Test
	public void testConstruction() {
		Tile tile = new Tile(3);
		assertEquals(3, tile.getValue());
	}

	@Test
	public void testX() {
		Tile tile = new Tile(1);
		tile.setX(5);

		assertEquals(5, tile.getX());
	}

	@Test
	public void testY() {
		Tile tile = new Tile(2);
		tile.setY(7);

		assertEquals(7, tile.getY());
	}

	@Test
	public void testValue() {
		Tile tile = new Tile(4);
		tile.setValue(5);

		assertEquals(5, tile.getValue());
	}
}
