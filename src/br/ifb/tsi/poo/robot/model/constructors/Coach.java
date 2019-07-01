package br.ifb.tsi.poo.robot.model.constructors;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.Robot;

public abstract class Coach {
	
	public Fighter trainFighter() {
		return new Robot();
	}
}
