package com.sbye.mowit.tondeuse.move;

public enum Orientation {

	EST("E"), OUEST("W"), SUD("S"), NORD("N");

	private final String orientation;

	Orientation(String direction) {
		orientation = direction;
	}

	public static Orientation get(String o) {
		Orientation orient = NORD;
		for (Orientation or : Orientation.values()) {
			if(or.toString().equals(o)) {
				orient= or;
			}
		}
		return orient;
	}

	@Override
	public String toString() {
		return String.valueOf(orientation);
	}

	

}
