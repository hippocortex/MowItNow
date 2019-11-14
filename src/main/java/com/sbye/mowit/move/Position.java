package com.sbye.mowit.move;

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

	public Orientation tournerGauche() {
		// TODO Auto-generated method stub
		Orientation next = null;

		switch (orientation) {
		case NORD:
			next = Orientation.EST;
			break;
		case SUD:
			next = Orientation.OUEST;
			break;
		case EST:
			next = Orientation.SUD;
			break;
		case OUEST:
			next = Orientation.NORD;
			break;
		}
		orientation=next;
		return next;
	}

	public Orientation tournerDroite() {
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
		orientation=next;
		return next;
	}

	public Position next() {
		nextAbcisse=abcisse;
		nextOrdonnee=ordonnee;
		switch (orientation) {
		case NORD:
			nextOrdonnee = getOrdonnee() + 1;
			
			break;
		case SUD:
			nextOrdonnee = getOrdonnee() - 1;
			break;
		case EST:
			nextAbcisse = getAbcisse() - 1;
			break;
		case OUEST:
			nextAbcisse = getAbcisse() + 1;
			break;
		}
		return new Position(nextAbcisse, nextOrdonnee, orientation);
	}
	
	public void avancer() {
		switch (orientation) {
		case NORD:
			ordonnee+=1;
			break;
		case SUD:
			ordonnee-=1;
			break;
		case EST:
			abcisse-=1;
			break;
		case OUEST:
			abcisse+=1;
			break;
		}

	}

	public int getNextAbcisse() {
		return nextAbcisse;
	}
	
	public int getNextOrdonnee() {
		return nextOrdonnee;
	}

	public void setOrientation(Orientation next) {
		orientation=next;
	}

}
