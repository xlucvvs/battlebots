package br.ifb.tsi.poo.robot.model.skills.impl;

import java.util.Random;

import br.ifb.tsi.poo.robot.model.skills.Skill;
import br.ifb.tsi.poo.robot.model.skills.SkillGenerator;

public class RandomSkillGenerator implements SkillGenerator{
	private Skill[] skills;
	private int qtde;
	
	public RandomSkillGenerator() {
		super();
		this.qtde = 6;
		this.skills = new Skill[qtde];
		this.skills[0] = new Shot();
		this.skills[1] = new FlamingBlade();
		this.skills[2] = new ConcentratedLoad();
		this.skills[3] = new Massacre();
		this.skills[4] = new DeathChallenge();
		this.skills[5] = new IronShield();
		
	}



	@Override
	public Skill generateSkill() {
		
		return this.skills[new Random().nextInt(qtde)];
	}
}
