package com.sbye.mowit.tondeuse;

public class IllegalPositionException extends Exception {

	private static final long serialVersionUID = 4271093361131855441L;

	public IllegalPositionException() {
		super("Position ou dimension impossible sur la pelouse");
	}
	
	public IllegalPositionException(String msg) {
		super(msg);
	}
}
