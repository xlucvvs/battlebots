package br.ifb.tsi.poo.robot.model.skills.impl;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;
import br.ifb.tsi.poo.robot.model.skills.SimpleTargetSkill;

public class ConcentratedLoad extends SimpleTargetSkill{

private final int coast = 100;
	
	@Override
	public void apply(SkillRobot invoker, Fighter target) {
		
		
		if(invoker.getEnergy() >= coast) {
			System.out.println(invoker.getName() + " aplicou a habilidade carga concentrada no " + target.getName() );
			invoker.reduceEnergy(coast);
			invoker.setHealth(invoker.getHealth() - 15);
			target.defend(50);
		}else {
			System.out.println("Energia insuficiente!");
		}
	}
	
	@Override
	public String toString() {
		return "Carga Concentrada (50 de dano) E=-100 S=-15";
	}

	@Override
	public int getCoast() {
		return coast;
	}

}
