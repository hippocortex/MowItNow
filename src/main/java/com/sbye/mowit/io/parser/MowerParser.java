package com.sbye.mowit.io.parser;

import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.base.Preconditions;
import com.sbye.mowit.tondeuse.IllegalPositionException;
import com.sbye.mowit.tondeuse.Pelouse;
import com.sbye.mowit.tondeuse.Tondeuse;
import com.sbye.mowit.tondeuse.move.Orientation;
import com.sbye.mowit.tondeuse.move.Position;

public class MowerParser {

	private final AtomicInteger counter = new AtomicInteger();
	private static final String SEPARATOR = " ";
	private static final String PATTERN = "^\\d+ \\d+ [N|E|W|S]$";
	private Pelouse pelouse;
	
	public MowerParser(Pelouse lawn) {
		this.pelouse = lawn;
	}

	public Tondeuse parse(String line) throws IllegalPositionException {
		Preconditions.checkArgument(line.matches(PATTERN),
				"Erreur de parse des infos de la pelouse [attendue: 'x y orientation'; actuelle: '" + line + "']");
		String[] champs = line.split(SEPARATOR);
		int x = Integer.valueOf(champs[0]);
		int y = Integer.valueOf(champs[1]);
		Orientation orientation = Orientation.get(champs[2]);

		return new Tondeuse(counter.getAndIncrement(), new Position(x, y, orientation), pelouse);

	}

}
