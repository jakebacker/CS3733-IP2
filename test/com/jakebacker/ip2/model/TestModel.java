package com.jakebacker.ip2.model;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.List;

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

	@Test
	public void testAvailableMovesNull() {
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

		List<MoveType> moves = model.availableMoves();

		assertEquals(0, moves.size());
	}

	@Test
	public void testAvailableMoves() {

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

		JLabel dummyLabel = new JLabel("a");


		model.select(dummyLabel, 0, 0);

		List<MoveType> moves = model.availableMoves();

		assertEquals(1, moves.size());
		assertTrue(moves.contains(MoveType.Right));


		model.select(dummyLabel, 1, 0);

		moves = model.availableMoves();

		assertEquals(1, moves.size());
		assertTrue(moves.contains(MoveType.Right));


		model.select(dummyLabel, 2, 0);

		moves = model.availableMoves();

		assertEquals(1, moves.size());
		assertTrue(moves.contains(MoveType.Left));


		model.select(dummyLabel, 0, 1);

		moves = model.availableMoves();

		assertEquals(3, moves.size());
		assertTrue(moves.contains(MoveType.Up));
		assertTrue(moves.contains(MoveType.Right));
		assertTrue(moves.contains(MoveType.Down));


		model.select(dummyLabel, 1, 1);

		moves = model.availableMoves();

		assertEquals(2, moves.size());
		assertTrue(moves.contains(MoveType.Up));
		assertTrue(moves.contains(MoveType.Right));


		model.select(dummyLabel, 2, 1);

		moves = model.availableMoves();

		assertEquals(1, moves.size());
		assertTrue(moves.contains(MoveType.Up));


		model.select(dummyLabel, 0, 2);

		moves = model.availableMoves();

		assertEquals(2, moves.size());
		assertTrue(moves.contains(MoveType.Up));
		assertTrue(moves.contains(MoveType.Right));


		model.select(dummyLabel, 1, 2);

		moves = model.availableMoves();

		assertEquals(2, moves.size());
		assertTrue(moves.contains(MoveType.Up));
		assertTrue(moves.contains(MoveType.Right));
	}
}
