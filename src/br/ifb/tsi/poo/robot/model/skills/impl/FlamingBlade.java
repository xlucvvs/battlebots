package br.ifb.tsi.poo.robot.model.skills.impl;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;
import br.ifb.tsi.poo.robot.model.skills.SimpleTargetSkill;

public class FlamingBlade extends SimpleTargetSkill{

	private final int coast = 60;
	
	@Override
	public void apply(SkillRobot invoker, Fighter target) {
		
		
		if(invoker.getEnergy() >= coast) {
			System.out.println(invoker.getName() + " aplicou a habilidade lamina flamejante no " + target.getName() );
			invoker.reduceEnergy(coast);
			target.defend(30);
		}else {
			System.out.println("Energia insuficiente!");
		}
	}
	
	@Override
	public String toString() {
		return "Lamina Flamejante (30 de dano) E=-60";
	}

	@Override
	public int getCoast() {
		return coast;
	}

}
