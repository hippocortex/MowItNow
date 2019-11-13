package com.sbye.mowit.io.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sbye.mowit.tondeuse.IllegalPositionException;
import com.sbye.mowit.tondeuse.Pelouse;
import com.sbye.mowit.tondeuse.Tondeuse;

class MowerParserTest {

	MowerParser parser = new MowerParser(new Pelouse(3,3));
	@Test
	void test() throws IllegalPositionException {
		Tondeuse tond = parser.parse(new String ("2 3 N"));
		assertEquals(0, tond.getId());
		assertEquals(2,tond.getPosition().getAbcisse());
		assertEquals(3,tond.getPosition().getOrdonnee());
	}

	@Test
	void testDeuxTondeuse() throws IllegalPositionException {
		Tondeuse tond = parser.parse(new String ("2 3 N"));
		Tondeuse tond2 = parser.parse(new String("1 1 S"));
		assertEquals(0, tond.getId());
		assertEquals(1,tond2.getId());
		
	}
	
	@Test
	void parseExceptionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->parser.parse(new String("3 3 3 3")));
	}
}
