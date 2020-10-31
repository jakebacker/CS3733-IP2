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
		Tile t = new Tile(4);
		Tile t2 = new Tile(5);

		board.addTile(t, 1, 2);
		board.addTile(t2, 2, 2);

		model.setBoard(board);

		JLabel label = new JLabel("a");
		JLabel label2 = new JLabel("b");

		model.select(label, 1, 2);

		new SelectTileController(model, new NumbersPuzzleApp(model)).process(label2, 2, 2);

		assertEquals(label2.getBackground(), Model.SELECTED_COLOR);
		assertEquals(label.getBackground(), Model.NORMAL_COLOR);
		assertEquals(model.getSelectedTile(), t2);
		assertEquals(model.getSelectedLabel(), label2);
	}
}
