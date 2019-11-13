package com.sbye.mowit.io.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Preconditions;
import com.sbye.mowit.tondeuse.Controller;
import com.sbye.mowit.tondeuse.IllegalPositionException;
import com.sbye.mowit.tondeuse.Pelouse;
import com.sbye.mowit.tondeuse.Tondeuse;
import com.sbye.mowit.tondeuse.move.Instruction;

public class MowerFileParser {

	public Controller processFromFile(File fichier) throws IllegalPositionException{
		String ligne;
		Controller controller = null;

		List<String> strings = new ArrayList<String>();
		try(BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader(fichier))){
			while ((ligne = lecteurAvecBuffer.readLine()) != null)
				strings.add(ligne);
			controller = parse(strings);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return controller;

	}

	

	public Controller processFromPath(String inputFileName) {
		Controller controller = null;
		try {
			controller = parse(Files.readAllLines(Paths.get(inputFileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return controller;
	}

	private Controller parse(List<String> pLines) throws IllegalPositionException {
		Preconditions.checkArgument(pLines.size() > 2, "Erreur de chargement du moniteur: ficher incomplet");
		Iterator<String> lines = pLines.iterator();
		LawnParser lawnParser = new LawnParser();
		InstructionParser instructionParser = new InstructionParser();
		Pelouse lawn = lawnParser.parse(lines.next());
		MowerParser mowerParser = new MowerParser(lawn);
		List<Tondeuse> mowers = new ArrayList<Tondeuse>();
		while (lines.hasNext()) {
			Tondeuse mower = mowerParser.parse(lines.next());
			List<Instruction> instructions = instructionParser.parse(lines.next());
			mower.setInstructions(instructions);
			mowers.add(mower);
		}
		return new Controller(mowers);
	}
}
