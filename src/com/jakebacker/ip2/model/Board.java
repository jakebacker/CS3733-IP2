package com.jakebacker.ip2.model;


public class Board {
	Tile[][] tiles = new Tile[3][3]; // tiles[y][x]

	Tile[][] tilesOriginal = new Tile[3][3];

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

	public void save() {
		deepCopy(tiles, tilesOriginal);
	}

	public void reset() {
		deepCopy(tilesOriginal, tiles);
	}

	public void deepCopy(Tile[][] original, Tile[][] out) {
		for (int y=0; y < original.length; y++) {
			for (int x=0; x<original[y].length; x++) {
				out[y][x] = original[y][x].deepCopy();
			}
		}
	}
}
