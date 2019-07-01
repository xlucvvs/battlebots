package br.ifb.tsi.poo.robot.model.robots.parts;

import br.ifb.tsi.poo.robot.model.skills.Skill;

public class SkillPart extends Part {
private Skill skill;
	
	public SkillPart(int attack, int defense, int velocity, int durability) {
		super(attack, defense, velocity, durability);	
	}

	public SkillPart(Part part) {
		super(part.getAttack(), part.getDefense(), part.getVelocity(), part.getDurability());

	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		String msg = super.toString();
		msg +=" "+ (this.getSkill()!=null?this.getSkill():"");
		return msg;
	}
}
