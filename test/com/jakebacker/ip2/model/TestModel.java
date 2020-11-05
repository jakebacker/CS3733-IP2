package com.jakebacker.ip2.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestModel {

	static Model model;
	static Board board;
	
	@BeforeAll
	static void beforeAll() {
		model = new Model();
		board = new Board();

		model.setBoard(board);
	}

	@BeforeEach
	public void beforeEach() {
		board.addTile(new Tile(3), 0, 0);
		board.addTile(new Tile(6), 1, 0);
		board.addTile(new Tile(4), 2, 0);

		board.addTile(new Tile(1), 0, 1);
		board.addTile(new Tile(7), 1, 1);
		board.addTile(new Tile(9), 2, 1);

		board.addTile(new Tile(2), 0, 2);
		board.addTile(new Tile(5), 1, 2);
		board.addTile(new Tile(8), 2, 2);

		model.setGameOver(false);
		model.clearSelectedTile();
	}
	
	@Test
	public void testSetBoard() {
		assertEquals(board, model.getBoard());
	}

	@Test
	public void testSelect() {
		Tile t = new Tile(4);

		board.addTile(t, 1, 2);

		JLabel label = new JLabel("a");

		model.select(label, 1, 2);

		assertEquals(t, model.getSelectedTile());
		assertEquals(label, model.getSelectedLabel());
		assertEquals(label.getBackground(), Model.SELECTED_COLOR);
	}

	@Test
	public void testClear() {
		Tile t = new Tile(4);

		board.addTile(t, 1, 2);

		JLabel label = new JLabel("a");

		model.select(label, 1, 2);
		model.clearSelectedTile();

		assertNull(model.getSelectedTile());
		assertNull(model.getSelectedLabel());
		assertEquals(label.getBackground(), Model.NORMAL_COLOR);
	}

	@Test
	public void testGameOver() {
		model.setGameOver(true);

		assertTrue(model.isGameOver());
	}

	@Test
	public void testAvailableMovesNull() {
		List<MoveType> moves = model.availableMoves();

		assertEquals(0, moves.size());
	}

	@Test
	public void testAvailableMovesEmpty() {

		board.addTile(new Tile(-1), 0, 0);

		model.selectedTile = model.board.getTile(0, 0);

		List<MoveType> moves = model.availableMoves();

		assertEquals(0, moves.size());
	}

	@Test
	public void testAvailableMoves() {
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

	@Test
	public void testTryMove() {
		JLabel dummyLabel = new JLabel("a");

		assertFalse(model.tryMove(MoveType.Right));

		model.select(dummyLabel, 0, 0);
		assertFalse(model.tryMove(MoveType.Left));

		assertTrue(model.tryMove(MoveType.Right));
		assertTrue(board.tiles[0][0].value <= -1);
		assertEquals(9, board.tiles[0][1].value);

		model.select(dummyLabel, 0, 2);
		assertTrue(model.tryMove(MoveType.Up));
		assertTrue(board.tiles[2][0].value <= -1);
		assertEquals(2, board.tiles[1][0].value);

		model.select(dummyLabel, 0, 1);
		assertTrue(model.tryMove(MoveType.Right));
		assertTrue(board.tiles[1][0].value <= -1);
		assertEquals(9, board.tiles[1][1].value);

		model.select(dummyLabel, 1, 2);
		assertTrue(model.tryMove(MoveType.Up));
		assertTrue(board.tiles[2][1].value <= -1);
		assertEquals(45, board.tiles[1][1].value);

		model.select(dummyLabel, 2, 2);
		assertTrue(model.tryMove(MoveType.Up));
		assertTrue(board.tiles[2][2].value <= -1);
		assertEquals(72, board.tiles[1][2].value);

		model.select(dummyLabel, 2, 0);
		assertTrue(model.tryMove(MoveType.Down));
		assertTrue(board.tiles[0][2].value <= -1);
		assertEquals(18, board.tiles[1][2].value);

		model.select(dummyLabel, 2, 1);
		assertTrue(model.tryMove(MoveType.Left));
		assertTrue(board.tiles[1][2].value <= -1);
		assertEquals(27, board.tiles[1][1].value);
	}

	@Test
	public void testCheckGameOver() {
		board.addTile(new Tile(-1), 1, 0);

		board.addTile(new Tile(-1), 0, 1);
		board.addTile(new Tile(-1), 2, 1);

		board.addTile(new Tile(-1), 1, 2);

		assertTrue(model.checkGameOver());

		board.addTile(new Tile(6), 1, 0);

		board.addTile(new Tile(1), 0, 1);
		board.addTile(new Tile(9), 2, 1);
		board.addTile(new Tile(5), 1, 2);

		assertFalse(model.checkGameOver());
	}

	@Test
	public void testCheckGameWin() {

		board.addTile(new Tile(-1), 0, 0);
		board.addTile(new Tile(-1), 1, 0);
		board.addTile(new Tile(-1), 2, 0);

		board.addTile(new Tile(-1), 0, 1);
		board.addTile(new Tile(-1), 2, 1);

		board.addTile(new Tile(-1), 0, 2);
		board.addTile(new Tile(-1), 1, 2);
		board.addTile(new Tile(-1), 2, 2);

		assertTrue(model.checkGameWin());

		board.addTile(new Tile(-1), 1, 1);
		board.addTile(new Tile(7), 0, 0);

		assertFalse(model.checkGameWin());
	}
}
