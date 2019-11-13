package com.sbye.mowit.io.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sbye.mowit.tondeuse.Controller;

class MowerFileParserTest {

	@Test
	void testProcessFromPath() {
		MowerFileParser mfp = new MowerFileParser();
		Controller control = mfp.processFromPath("c:/sbye/test.txt");
		Assertions.assertEquals(2, control.getTondeuses().size());
		
	}

	@Test
	void testProcessFromFile() {
		
	}
}
