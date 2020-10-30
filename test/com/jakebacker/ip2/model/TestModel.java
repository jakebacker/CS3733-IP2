package com.jakebacker.ip2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestModel {

	@Test
	public void testSet() {
		Model model = new Model();
		Board board = new Board();

		model.setBoard(board);

		assertEquals(board, model.getBoard());
	}
}
