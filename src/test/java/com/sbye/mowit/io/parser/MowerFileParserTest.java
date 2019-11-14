package com.sbye.mowit.io.parser;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sbye.mowit.tondeuse.Controller;
import com.sbye.mowit.tondeuse.IllegalPositionException;

class MowerFileParserTest {

	@Test
	void testProcessFromFile() throws URISyntaxException {
		MowerFileParser mfp = new MowerFileParser();
		Controller control = null;
		try {
			URI uri = ClassLoader.getSystemResource("com/sbye/mowit/io/parser/test.txt").toURI();

			control = mfp.processFromFile(new File(uri));
		} catch (IllegalPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assertions.assertEquals(2, control.getTondeuses().size());
		
	}

}
