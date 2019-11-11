package com.sbye.mowit.tondeuse;

import com.sbye.mowit.tondeuse.move.Orientation;
import com.sbye.mowit.tondeuse.move.Position;

public class Tondeuse {

	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Tondeuse.class);
	private Position position;
	private Orientation orientation;
	private Pelouse pelouse;
	private int id;

	public Tondeuse(int id, Position pos, Pelouse pel) throws IllegalPositionException {
		checkConditions(pos, pel);
		this.pelouse = pel;

		position = pos;
		this.id = id;
	}

	private void checkConditions(Position position, Pelouse pelouse) throws IllegalPositionException {
		if (!(pelouse.contains(position.getAbcisse(), position.getOrdonnee())) || position.getAbcisse() < 0
				|| position.getOrdonnee() < 0)
			throw new IllegalPositionException();

	}

	public int getId() {
		return this.id;
	}

	public Position getPosition() {
		return position;
	}

	public void deplacer(String mouvement) {
		switch (mouvement) {
		case "A":
			position.avancer();
			logger.debug("avancer la tondeuse id " + getId());
			break;
		case "G":
			this.orientation = position.tournerGauche();
			System.out.println("tourner");
			break;
		case "D":
			this.orientation = position.tournerDroite();
			System.out.println("tourner");
			break;
		}
		System.out.println(this.toString());
	}

	public void avancer() {
		if (pelouse.contains(position.getNextAbcisse(), position.getNextOrdonnee()))
			position.avancer();
	}

	public Pelouse getPelouse() {
		return pelouse;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("Tondeuse n° ");
		return builder.append(this.id).append(" position - abcisse: ").append(this.position.getAbcisse())
				.append(" position-ordonnee ").append(" direction ").append(this.position.getOrientation()).toString();
	}
}
