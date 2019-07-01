package br.ifb.tsi.poo.robot.model.skills;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;

public abstract class SimpleTargetSkill extends Skill{

	public abstract void apply(SkillRobot invocador, Fighter target);
}
