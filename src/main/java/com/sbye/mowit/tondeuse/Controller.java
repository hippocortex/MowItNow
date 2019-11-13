package com.sbye.mowit.tondeuse;

import java.util.List;
import java.util.stream.Stream;

public class Controller {

	private List<Tondeuse> tondeuses;
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Controller.class);

	public Controller(List<Tondeuse> mowers) {
		this.tondeuses = mowers;
	}
	
	public List<Tondeuse> getTondeuses(){
		return tondeuses;
	}

	public void tondeusesPositions() {
		for (Tondeuse tondeuse : tondeuses) {
			logger.debug("Tondeuse Id "+tondeuse.getId()+"position abcisse "+tondeuse.getPosition().getAbcisse()+" ordonnee "+tondeuse.getPosition().getOrdonnee()+"orientation "+tondeuse.getPosition().getOrientation());
		}
	}
	
	public void lancer() {
		Stream<Tondeuse> sTond = tondeuses.stream();
		sTond.forEach(s->s.run());
	}
}
