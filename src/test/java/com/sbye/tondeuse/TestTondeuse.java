package com.sbye.tondeuse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sbye.mowit.tondeuse.IllegalPositionException;
import com.sbye.mowit.tondeuse.Pelouse;
import com.sbye.mowit.tondeuse.Tondeuse;
import com.sbye.mowit.tondeuse.move.Orientation;
import com.sbye.mowit.tondeuse.move.Position;

public class TestTondeuse {

	Tondeuse tondeuse;
	@Before
	public void init() throws IllegalPositionException {
		 tondeuse = new Tondeuse(1, new Position(1, 1, Orientation.NORD), new Pelouse(5, 5));

	}

	@Test
	public void avancerTest() {
		avancer(1);
		assertEquals(2, tondeuse.getPosition().getOrdonnee());
	}

	@Test
	public void avancerLimiteTest() {

		avancer(4);
		assertEquals(5, tondeuse.getPosition().getOrdonnee());
	}

	@Test
	public void avancerHorsLimiteTest() {
		avancer(6);
		assertEquals(5, tondeuse.getPosition().getOrdonnee());
	}
	
	@Test(expected = IllegalPositionException.class)
	public void limitesIntialTest() throws IllegalPositionException {
		Tondeuse nTondeuse = new Tondeuse(2,new Position(-1, 3, Orientation.NORD),new Pelouse(6,6));
	}

	private void avancer(int x) {
		for (int i = 0; i < x; i++) {
			tondeuse.avancer();
		}
	}

}
