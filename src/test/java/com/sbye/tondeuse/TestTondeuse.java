package com.sbye.tondeuse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sbye.mowit.move.Orientation;
import com.sbye.mowit.move.Position;
import com.sbye.mowit.tondeuse.IllegalPositionException;
import com.sbye.mowit.tondeuse.Pelouse;
import com.sbye.mowit.tondeuse.Tondeuse;

public class TestTondeuse {

	Tondeuse tondeuse;
	Tondeuse tondeuse2;

	@Before
	public void init() throws IllegalPositionException {
		tondeuse = new Tondeuse(1, new Position(1, 1, Orientation.NORD), new Pelouse(5, 5));
		tondeuse2 = new Tondeuse(2, new Position(2, 2, Orientation.OUEST), new Pelouse(6, 6));
	}

	@Test
	public void avancerOrdonneeTest() {
		avancer(1, tondeuse);
		assertEquals(2, tondeuse.getPosition().getOrdonnee());
	}

	@Test
	public void avancerOrdonneeLimiteTest() {
		avancer(4, tondeuse);
		assertEquals(5, tondeuse.getPosition().getOrdonnee());
	}

	@Test
	public void avancerOrdonneeHorsLimiteTest() {
		avancer(7, tondeuse);
		assertEquals(5, tondeuse.getPosition().getOrdonnee());
	}

	@Test(expected = IllegalPositionException.class)
	public void limitesIntialTest() throws IllegalPositionException {
		Tondeuse nTondeuse = new Tondeuse(2, new Position(-1, 3, Orientation.NORD), new Pelouse(6, 6));
	}

	@Test
	public void avancerAbcisseTest() {
		avancer(1, tondeuse2);
		assertEquals(3, tondeuse2.getPosition().getAbcisse());
	}

	@Test
	public void avancerAbcisseLimiteTest() {
		avancer(4, tondeuse2);
		assertEquals(6, tondeuse2.getPosition().getAbcisse());
	}

	@Test
	public void avancerAbcisseHorsLimiteTest() {
		avancer(7, tondeuse2);
		assertEquals(6, tondeuse2.getPosition().getAbcisse());
	}

	@Test
	public void verifierPositionTondeuse() {
		assertEquals(1, tondeuse.getPosition().getAbcisse());
		assertEquals(2, tondeuse2.getPosition().getOrdonnee());
	}

	@Test
	public void tournerDroiteTest() {
		tondeuse.tournerDroite();
		assertEquals(Orientation.OUEST, tondeuse.getPosition().getOrientation());
	}

	@Test
	public void tournerGaucheTest() {
		tondeuse2.tournerGauche();
		assertEquals(Orientation.NORD, tondeuse2.getPosition().getOrientation());
	}

	private void avancer(int x, Tondeuse tondeuse) {
		for (int i = 0; i < x; i++) {
			tondeuse.avancer();
		}
	}

}
