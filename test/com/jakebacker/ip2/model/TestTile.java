package com.jakebacker.ip2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTile {

	@Test
	public void testConstruction() {
		Tile tile = new Tile(3);
		assertEquals(3, tile.value);
	}
}
