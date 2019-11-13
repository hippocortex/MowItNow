package com.sbye.mowit.io.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sbye.mowit.tondeuse.Pelouse;

class LawnParserTest {
	LawnParser parser = new LawnParser();

	@Test
	void testParse() {
		String line = "2 2";
		Pelouse pel = parser.parse(line);
		assertEquals(pel.getHauteur(), 2);
		assertEquals(pel.getLargeur(), 2);
	}

	@Test  
	void testParseErrorFormat() {
		String line = "2 2 7";
		Assertions.assertThrows(IllegalArgumentException.class, ()-> parser.parse(line));
		
	}
}
