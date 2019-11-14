package com.sbye.mowit.move;

import com.sbye.mowit.tondeuse.Tondeuse;

public enum Instruction {

	DROITE('D'){
		@Override
		public void bouger(Tondeuse tond) {
			tond.tournerDroite();
		}
	},GAUCHE('G'){
		@Override
		public void bouger(Tondeuse tond) {
			tond.tournerGauche();
		}
	},AVANCE('A'){
		@Override
		public void bouger(Tondeuse tond) {
			tond.avancer();
		}
	};
	char instruct;
	
	Instruction(char inst) {
		this.instruct=inst;
	}
	
	public char getInstruction() {
		return instruct;
	}
	
	public String toString() {
		return Character.toString(instruct);
	}
	
	public abstract void bouger(Tondeuse tond);
}
