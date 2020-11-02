package com.jakebacker.ip2.model;

public class Tile {

	public int value;
	int x;
	int y;

	public Tile(int value) {
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Tile deepCopy() {
		Tile copy = new Tile(value);
		copy.x = x;
		copy.y = y;

		return copy;
	}
}
