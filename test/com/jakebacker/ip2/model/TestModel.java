package com.jakebacker.ip2.model;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestModel {

	@Test
	public void testSetBoard() {
		Model model = new Model();
		Board board = new Board();

		model.setBoard(board);

		assertEquals(board, model.getBoard());
	}

	@Test
	public void testSelect() {
		Model model = new Model();
		Board board = new Board();
		Tile t = new Tile(4);

		board.addTile(t, 1, 2);

		model.setBoard(board);

		JLabel label = new JLabel("a");

		model.select(label, 1, 2);

		assertEquals(t, model.getSelectedTile());
		assertEquals(label, model.getSelectedLabel());
		assertEquals(label.getBackground(), Model.SELECTED_COLOR);
	}

	@Test
	public void testClear() {
		Model model = new Model();
		Board board = new Board();
		Tile t = new Tile(4);

		board.addTile(t, 1, 2);

		model.setBoard(board);

		JLabel label = new JLabel("a");

		model.select(label, 1, 2);
		model.clearSelectedTile();

		assertNull(model.getSelectedTile());
		assertNull(model.getSelectedLabel());
		assertEquals(label.getBackground(), Model.NORMAL_COLOR);
	}

	@Test
	public void testGameOver() {
		Model model = new Model();

		model.setGameOver(true);

		assertTrue(model.isGameOver());
	}
}
