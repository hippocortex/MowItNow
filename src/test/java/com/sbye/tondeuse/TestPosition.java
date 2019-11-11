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
	public void tournerGaucheTest() {
		Position position = new Position(2, 2, Orientation.NORD);
		position = position.tournerGauche();
		logger.debug("orientation " +position.getOrientation());
		Assertions.assertEquals("E", position.getOrientation());
	}

	@Test
	public void tournerDroiteTest() {
		Position position = new Position(2, 2, Orientation.NORD);
		position = position.tournerDroite();
		
		Assertions.assertEquals("W", position.getOrientation());
	}

	@Test
	public void tournerMultiplesTest() {
		Position position = new Position(2, 2, Orientation.NORD);
		position=position.tournerGauche();
		position  = position.tournerGauche();
		position = position.tournerGauche();
		position = position.tournerDroite();
		Assertions.assertEquals("S", position.getOrientation());
	}
}
