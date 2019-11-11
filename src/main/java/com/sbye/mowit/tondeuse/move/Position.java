package com.sbye.mowit.tondeuse.move;

import org.slf4j.Logger;

public class Position {

	Logger logger = org.slf4j.LoggerFactory.getLogger(Position.class);
	private int abcisse;
	private int ordonnee;
	private Orientation orientation;
	private int nextAbcisse;
	private int nextOrdonnee;

	public Position() {
		this.abcisse = 0;
		this.ordonnee = 0;
		this.orientation = Orientation.NORD;
		nextAbcisse = 0;
		nextOrdonnee = 1;
	}

	public Position(int abcis, int ord, Orientation orient) {
		checkCoord(abcis, ord);
		abcisse = abcis;
		ordonnee = ord;
		orientation = orient;

	}

	private void checkCoord(int abcis, int ord) {
		// TODO Auto-generated method stub

	}

	public int getAbcisse() {
		return abcisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public Position tournerGauche() {
		// TODO Auto-generated method stub
		Orientation next = null;

		switch (orientation) {
		case NORD:
			next = orientation.EST;
			break;
		case SUD:
			next = Orientation.OUEST;
			break;
		case EST:
			next = Orientation.SUD;
			break;
		case OUEST:
			next =Orientation.NORD;
			break;
		}
		return new Position(abcisse, ordonnee, next);
	}

	public Position tournerDroite() {
		Orientation next = null;
		switch (orientation) {
		case NORD:
			next = Orientation.OUEST;
			break;
		case SUD:
			next = Orientation.EST;
			break;
		case EST:
			next = Orientation.NORD;
			break;
		case OUEST:
			next = Orientation.SUD;
			break;
		}
		return new Position(abcisse, ordonnee, next);
	}

	public void avancer() {
		switch (orientation) {
		case NORD:
			nextOrdonnee = getOrdonnee() + 1;
			ordonnee = getNextOrdonnee();
			break;
		case SUD:
			nextOrdonnee = getOrdonnee() - 1;
			ordonnee = getNextOrdonnee();
			break;
		case EST:
			nextAbcisse = getAbcisse() - 1;
			abcisse = getNextAbcisse();
			break;
		case OUEST:
			nextAbcisse = getAbcisse() + 1;
			abcisse = getNextAbcisse();
			break;
		}

	}

	public int getNextAbcisse() {
		return nextAbcisse;
	}

	public int getNextOrdonnee() {
		return nextOrdonnee;
	}

}
