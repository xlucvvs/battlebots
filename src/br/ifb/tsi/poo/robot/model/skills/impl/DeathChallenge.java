package br.ifb.tsi.poo.robot.model.skills.impl;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;
import br.ifb.tsi.poo.robot.model.skills.SimpleTargetSkill;

public class DeathChallenge extends SimpleTargetSkill{
	
	private final int coast = 150;
	
	@Override
	public void apply(SkillRobot invoker, Fighter target) {
		
		
		if(invoker.getEnergy() >= coast) {
			System.out.println(invoker.getName() + " aplicou a habilidade desafio da morte no " + target.getName() );
			invoker.reduceEnergy(coast);
			invoker.setHealth(invoker.getHealth() - 60);
			target.defend(75);
		}else {
			System.out.println("Energia insuficiente!");
		}
	}
	
	@Override
	public String toString() {
		return "Desafio da Morte (75 de dano) E=-150 S=-60";
	}

	@Override
	public int getCoast() {
		return coast;
	}
}
