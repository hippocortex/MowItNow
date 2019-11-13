package com.sbye.mowit.io.parser;

import com.google.common.base.Preconditions;
import com.sbye.mowit.tondeuse.Pelouse;

public class LawnParser {

	private static final String PATTERN = "^\\d+ \\d+$";
	private static final String SEPARATOR = " ";

	public Pelouse parse(String line) {
		Preconditions.checkArgument(line.matches(PATTERN),
				"Erreur de parse des infos de la pelouse [attendue: 'x y'; actuelle: '" + line + "']");
		String[] champs = line.split(SEPARATOR);
		return new Pelouse(Integer.valueOf(champs[0]), Integer.valueOf(champs[1]));
	}

}
