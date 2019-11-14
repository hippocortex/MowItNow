package com.sbye.mowit;

import com.sbye.mowit.io.parser.MowerFileParser;
import com.sbye.mowit.tondeuse.Controller;
import com.sbye.mowit.tondeuse.IllegalPositionException;

/**
 *
 */
public class Tondre {
	public static void main(String... args) {
		org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Tondre.class);

		if (args.length == 1) {

			MowerFileParser parser = new MowerFileParser();
			Controller control = null;
			try {
				control = parser.processFromPath(args[0]);
				control.lancer();
				control.tondeusesPositions();
			} catch (IllegalPositionException e) {
				logger.info(e.getMessage());
			}

		} else {
			throw new IllegalArgumentException("Fichier ou chemin de fichier attendu");
		}
	}
}
