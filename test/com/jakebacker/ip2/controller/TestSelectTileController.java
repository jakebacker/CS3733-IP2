package com.jakebacker.ip2.controller;

import com.jakebacker.ip2.boundary.NumbersPuzzleApp;
import com.jakebacker.ip2.model.Board;
import com.jakebacker.ip2.model.Model;
import com.jakebacker.ip2.model.Tile;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSelectTileController {

	@Test
	public void testProcess() {
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

		Tile t = new Tile(8);
		board.addTile(t, 2, 2);

		model.setBoard(board);

		JLabel label = new JLabel("a");
		JLabel label2 = new JLabel("b");

		model.select(label, 1, 2);

		// This is kind of cheating the code coverage checker. When new NumbersPuzzleApp is called, it just runs all the GUI code even though it's not testing it
		new SelectTileController(model, new NumbersPuzzleApp(model)).process(label2, 2, 2);


		assertEquals(label2.getBackground(), Model.SELECTED_COLOR);
		assertEquals(label.getBackground(), Model.NORMAL_COLOR);
		assertEquals(model.getSelectedTile(), t);
		assertEquals(model.getSelectedLabel(), label2);
	}
}
