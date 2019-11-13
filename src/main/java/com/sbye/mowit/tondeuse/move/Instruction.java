package com.sbye.mowit.tondeuse.move;

public class Instruction {

	private char instruct;
	
	public Instruction(char inst) {
		this.instruct=inst;
	}
	
	public char getInstruction() {
		return instruct;
	}
	
	public String toString() {
		return Character.toString(instruct);
	}
}
