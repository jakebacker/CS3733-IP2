package com.jakebacker.ip2.model;

public class Board {
	Tile[][] tiles = new Tile[3][3]; // tiles[y][x]

	public Board() {

	}

	public void addTile(Tile tile, int x, int y) {
		tile.setX(x);
		tile.setY(y);

		tiles[y][x] = tile;

	}

	public Tile getTile(int x, int y) {
		return tiles[y][x];
	}
}
