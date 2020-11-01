package com.jakebacker.ip2.model;

public enum MoveType {
	Up(0,-1), Down(0,1), Left(-1,0), Right(1,0),
	None(0,0);

	final int deltaX;
	final int deltaY;

	MoveType(int dx, int dy) {
		this.deltaX = dx;
		this.deltaY = dy;
	}
}
