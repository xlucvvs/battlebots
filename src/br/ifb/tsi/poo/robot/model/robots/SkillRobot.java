package br.ifb.tsi.poo.robot.model.robots;

import java.util.ArrayList;
import java.util.List;

import br.ifb.tsi.poo.robot.model.robots.parts.SkillPart;
import br.ifb.tsi.poo.robot.model.skills.Skill;
import br.ifb.tsi.poo.robot.model.skills.InvokerTargetSkill;
import br.ifb.tsi.poo.robot.model.skills.SimpleTargetSkill;
import br.ifb.tsi.poo.robot.model.robots.parts.Part;


public class SkillRobot extends Robot implements SkillFighter{
	private int energia;
	private List<Skill> skills;
	private boolean modoDefesa;
	
	
	
	public SkillRobot (String name, Part head, Part body, Part leftArm, Part rightArm,
			Part legs) {
		super(name, head, body, leftArm, rightArm, legs);
		this.setEnergy(100);
		modoDefesa = false;
		this.skills = new ArrayList<>();
		SkillPart ph;
		if(head instanceof SkillPart) {
			ph = ((SkillPart) head);
			if(ph.getSkill() != null) {
				this.addSkill(ph.getSkill());
			}
		}
		if(head instanceof SkillPart) {
			ph = ((SkillPart) head);
			if(ph.getSkill() != null) {
				this.addSkill(ph.getSkill());
			}
		}
		if(legs instanceof SkillPart) {
			ph = ((SkillPart) legs);
			if(ph.getSkill() != null) {
				this.addSkill(ph.getSkill());
			}
		}
		if(leftArm instanceof SkillPart) {
			ph = ((SkillPart) leftArm);
			if(ph.getSkill() != null) {
				this.addSkill(ph.getSkill());
			}
		}
		if(rightArm instanceof SkillPart) {
			ph = ((SkillPart) rightArm);
			if(ph.getSkill() != null) {
				this.addSkill(ph.getSkill());
			}
		}
		
		
	}
	
	@Override
	public void defend(int dano) {
		if(modoDefesa) {
			dano = (dano * 80) / 100;
			super.defend(dano);
			this.recoverEnergy(10);
		}else {
			super.defend(dano);
		}
	}

	@Override
	public List<Skill> getSkills() {
		return this.skills;
	}

	@Override
	public void apply(Skill h, Fighter alvo) {
		if(h instanceof SimpleTargetSkill) {
			((SimpleTargetSkill) h).apply(this, alvo);
		}else if (h instanceof InvokerTargetSkill) {
			((InvokerTargetSkill) h).apply(this);
		}
	}

	@Override
	public void recoverEnergy() {
		int degreeOfRecover = 10;
		this.setEnergy(this.getEnergy() + degreeOfRecover);
	}
	
	@Override
	public void recoverEnergy(int degreeOfRecover) {
		this.setEnergy(this.getEnergy() + degreeOfRecover);
	}

	@Override
	public void addSkill(Skill h) {
		this.skills.add(h);
	}

	public int getEnergy() {
		return energia;
	}

	public void setEnergy(int energia) {
		this.energia = energia;
	}
	
	public void reduceEnergy(int energia) {
		this.energia -= energia;
	}
	
	public void enableDefense() {
		this.modoDefesa = true;
	}
	
	public void disableDefense() {
		this.modoDefesa = false;
	}

	@Override
	public String toString() {
		String msg = super.toString();
		msg += " E="+this.getEnergy()+" - "+ this.getSkills();
		return msg;
	}
}
