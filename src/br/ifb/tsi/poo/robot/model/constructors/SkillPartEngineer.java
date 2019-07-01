package br.ifb.tsi.poo.robot.model.constructors;

import java.util.Random;

import br.ifb.tsi.poo.robot.model.robots.parts.SkillPart;
import br.ifb.tsi.poo.robot.model.skills.SkillGenerator;
import br.ifb.tsi.poo.robot.model.skills.impl.RandomSkillGenerator;
import br.ifb.tsi.poo.robot.model.robots.parts.Part;

public class SkillPartEngineer extends PartEngineer{
	public Part forgePart() {
		SkillGenerator generator = new RandomSkillGenerator();
		SkillPart part = new SkillPart(super.forgePart());
		if(new Random().nextInt(100)<20) {
			part.setSkill(generator.generateSkill());
		}
		return part;
		
	}
}
