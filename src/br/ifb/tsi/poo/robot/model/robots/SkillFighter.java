package br.ifb.tsi.poo.robot.model.robots;

import java.util.List;

import br.ifb.tsi.poo.robot.model.skills.Skill;


public interface SkillFighter extends Fighter {
	public List<Skill> getSkills();
	public void addSkill(Skill h);
	public void apply(Skill h, Fighter alvo);
	
	public void reduceEnergy(int coast);
	public void recoverEnergy();
	public void recoverEnergy(int degreeOfRecovery);
	public int getEnergy();
	
	public void enableDefense();
	public void disableDefense();
}
