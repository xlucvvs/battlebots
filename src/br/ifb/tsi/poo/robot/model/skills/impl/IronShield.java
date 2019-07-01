package br.ifb.tsi.poo.robot.model.skills.impl;

import br.ifb.tsi.poo.robot.model.robots.SkillRobot;
import br.ifb.tsi.poo.robot.model.skills.InvokerTargetSkill;
import br.ifb.tsi.poo.robot.model.robots.Robot;

public class IronShield extends InvokerTargetSkill{
	
	private final int coast = 50;
	int onetime = 0;
	
	public void apply(Robot invoker) {
		
		SkillRobot skillInvoker = (SkillRobot) invoker;
		
		if(skillInvoker.getEnergy() >= coast && onetime == 0) {
			System.out.println(invoker.getName() + " utilizou escudo de ferro");
			skillInvoker.reduceEnergy(coast);
			invoker.rightArm.setDefense(invoker.rightArm.getDefense() + 10);
			onetime++;
		}else if (onetime > 0){
			System.out.println("Você já usou essa habilidade uma vez, espertinho!");
		} else {
			System.out.println("Energia insuficiente!");
		}
		
	}
	
	@Override
	public String toString() {
		return "Escudo de Ferro (+10 de defesa) E=-50 D=+10";
	}

	@Override
	public int getCoast() {
		return coast;
	}

}
