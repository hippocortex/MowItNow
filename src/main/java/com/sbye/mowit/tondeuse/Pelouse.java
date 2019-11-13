package com.sbye.mowit.tondeuse;

public class Pelouse {
	private int hauteur;
	private int largeur;
	
	public Pelouse(int hauteur, int largeur) {
		this.hauteur=hauteur;
		this.largeur=largeur;
	}
	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public boolean contains(int nextAbcisse, int nextOrdonnee) {
		return (nextAbcisse<=getLargeur() && nextOrdonnee<=getHauteur());
	}

}
