package com.jakebacker.ip2.boundary;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.boundary.UpdateButtons;
import com.jakebacker.ip2.model.Board;
import com.jakebacker.ip2.model.Model;
import com.jakebacker.ip2.model.MoveType;
import com.jakebacker.ip2.model.Tile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUpdateButtons {

	@Test
	public void testEnableButtons() {
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

		NumbersPuzzleApp app = new NumbersPuzzleApp(model);

		ArrayList<MoveType> moves = new ArrayList<>();
		
		moves.add(MoveType.Up);
		UpdateButtons.enableButtons(app, moves);
		assertTrue(app.getUpButton().isEnabled());

		moves.add(MoveType.Right);
		UpdateButtons.enableButtons(app, moves);
		assertTrue(app.getUpButton().isEnabled());
		assertTrue(app.getRightButton().isEnabled());

		moves.add(MoveType.Down);
		UpdateButtons.enableButtons(app, moves);
		assertTrue(app.getUpButton().isEnabled());
		assertTrue(app.getRightButton().isEnabled());
		assertTrue(app.getDownButton().isEnabled());

		moves.add(MoveType.Left);
		UpdateButtons.enableButtons(app, moves);
		assertTrue(app.getUpButton().isEnabled());
		assertTrue(app.getRightButton().isEnabled());
		assertTrue(app.getDownButton().isEnabled());
		assertTrue(app.getLeftButton().isEnabled());
		
		moves = new ArrayList<>();
		UpdateButtons.enableButtons(app, moves);
		assertFalse(app.getUpButton().isEnabled());
		assertFalse(app.getRightButton().isEnabled());
		assertFalse(app.getDownButton().isEnabled());
		assertFalse(app.getLeftButton().isEnabled());
	}
}
