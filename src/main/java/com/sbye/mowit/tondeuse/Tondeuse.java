package com.sbye.mowit.tondeuse;

import java.util.List;
import java.util.stream.Stream;

import com.sbye.mowit.move.Instruction;
import com.sbye.mowit.move.Position;

public class Tondeuse {

	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Tondeuse.class);
	private Position position;
	private Pelouse pelouse;
	private int id;
	private List<Instruction> instructions;

	public Tondeuse(int id, Position pos, Pelouse pel) throws IllegalPositionException {
		checkConditions(pos, pel);
		this.pelouse = pel;

		position = pos;
		this.id = id;
		logger.debug(
				"Creation d'une tondeuse Id " + id + " x: " + position.getAbcisse() + " y: " + position.getOrdonnee());
	}

	private void checkConditions(Position position, Pelouse pelouse) throws IllegalPositionException {
		if (!(pelouse.contains(position.getAbcisse(), position.getOrdonnee())) || position.getAbcisse() < 0
				|| position.getOrdonnee() < 0)
			throw new IllegalPositionException();

	}

	

	public void avancer() {
		Position pos = position.next();
		if (pelouse.contains(pos.getAbcisse(), pos.getOrdonnee()))
			position.avancer();
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public void run() {
		Stream<Instruction> si = instructions.stream();
		si.forEach(i -> i.bouger(this));
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("Tondeuse n° ");
		return builder.append(this.id).append(" position - abcisse: ").append(this.position.getAbcisse())
				.append(" position-ordonnee ").append(position.getOrdonnee()).append(" direction ")
				.append(this.position.getOrientation()).toString();
	}
	public int getId() {
		return this.id;
	}

	public Position getPosition() {
		return position;
	}

	public void tournerGauche() {
		position.tournerGauche();
	}

	public void tournerDroite() {
		position.tournerDroite();
	}
}
