package com.sbye.tondeuse;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;

import com.sbye.mowit.tondeuse.move.Orientation;
import com.sbye.mowit.tondeuse.move.Position;

/**
 * Unit test for simple App.
 */
public class TestPosition {

	Logger logger = org.slf4j.LoggerFactory.getLogger(TestPosition.class);

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 * @return
	 */
	@Test
	public void tournerGaucheNord() {
		Position position = new Position(2, 2, Orientation.NORD);
		Orientation orient = position.tournerGauche();
		logger.debug("orientation " + orient);
		Assertions.assertEquals(Orientation.EST, orient);
	}
	@Test
	public void tournerGaucheSud() {
		Position position = new Position(2, 2, Orientation.SUD);
		Orientation orient = position.tournerGauche();
		logger.debug("orientation " + orient);
		Assertions.assertEquals(Orientation.OUEST, orient);
	}
	
	@Test
	public void tournerGaucheEst() {
		Position position = new Position(2, 2, Orientation.EST);
		Orientation orient = position.tournerGauche();
		logger.debug("orientation " + orient);
		Assertions.assertEquals(Orientation.SUD, orient);
	}
	@Test
	public void tournerGaucheOuest() {
		Position position = new Position(2, 2, Orientation.OUEST);
		Orientation orient = position.tournerGauche();
		logger.debug("orientation " + orient);
		Assertions.assertEquals(Orientation.NORD, orient);
	}
	@Test
	public void tournerDroiteTest() {
		Position position = new Position(2, 2, Orientation.NORD);
		Orientation orient = position.tournerDroite();

		Assertions.assertEquals(Orientation.OUEST, orient);
	}
	@Test
	public void tournerDroiteTestSud() {
		Position position = new Position(2, 2, Orientation.SUD);
		Orientation orient = position.tournerDroite();

		Assertions.assertEquals(Orientation.EST, orient);
	}
	
	@Test
	public void tournerDroiteTestEst() {
		Position position = new Position(2, 2, Orientation.EST);
		Orientation orient = position.tournerDroite();

		Assertions.assertEquals(Orientation.NORD, orient);
	}
	@Test
	public void tournerDroiteTestOuest() {
		Position position = new Position(2, 2, Orientation.OUEST);
		Orientation orient = position.tournerDroite();

		Assertions.assertEquals(Orientation.SUD, orient);
	}
}
