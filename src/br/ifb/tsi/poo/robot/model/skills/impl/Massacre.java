package br.ifb.tsi.poo.robot.model.skills.impl;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;
import br.ifb.tsi.poo.robot.model.skills.SimpleTargetSkill;

public class Massacre extends SimpleTargetSkill{

	private final int coast = 120;
		
	@Override
	public void apply(SkillRobot invoker, Fighter target) {
			
			
		if(invoker.getEnergy() >= coast) {
			System.out.println(invoker.getName() + " aplicou a habilidade massacre no " + target.getName() );
			invoker.reduceEnergy(coast);
			invoker.setHealth(invoker.getHealth() - 20);
			target.defend(60);
		}else {
			System.out.println("Energia insuficiente!");
		}
	}
		
	@Override
	public String toString() {
		return "Massacre (60 de dano) E=-120 S=-20";
	}

	@Override
	public int getCoast() {
		return coast;
	}

}
