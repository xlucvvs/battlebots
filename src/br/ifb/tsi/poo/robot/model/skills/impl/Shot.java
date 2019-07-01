package br.ifb.tsi.poo.robot.model.skills.impl;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;
import br.ifb.tsi.poo.robot.model.skills.SimpleTargetSkill;

public class Shot extends SimpleTargetSkill{
	
	private final int coast = 50;
	
	@Override
	public void apply(SkillRobot invoker, Fighter target) {
		
		
		if(invoker.getEnergy() >= coast) {
			System.out.println(invoker.getName() + " aplicou a habilidade tiro no " + target.getName() );
			invoker.reduceEnergy(coast);
			target.defend(25);
		}else {
			System.out.println("Energia insuficiente!");
		}
	}
	
	@Override
	public String toString() {
		return "Tiro (25 de dano) E=-50";
	}

	@Override
	public int getCoast() {
		return coast;
	}
}
