package com.sbye.mowit.tondeuse.move;

public enum Orientation {

	EST("E"), OUEST("W"), SUD("S"), NORD("N");

	private final String orientation;

	private Orientation(String direction) {
		orientation = direction;
	}

	public String getOrientation() {
		return orientation;
	}

	@Override
	public String toString() {
		return String.valueOf(orientation);
	}

	

}
