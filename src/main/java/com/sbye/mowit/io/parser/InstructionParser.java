package com.sbye.mowit.io.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.sbye.mowit.tondeuse.move.Instruction;

public class InstructionParser {

	private static final String PATTERN = "^[A|D|G]+$";
	public List<Instruction> parse(String next) {
		Preconditions.checkArgument(next.matches(PATTERN),
				"Erreur de parse des infos de la pelouse [attendue: 'A... ou D...'; actuelle: '" + next + "']");
		List<Instruction> insts = new ArrayList<Instruction>();
		
		for(char instruct : next.toCharArray()) {
			insts.add(new Instruction(instruct));
		}
		return insts;
	}

}
