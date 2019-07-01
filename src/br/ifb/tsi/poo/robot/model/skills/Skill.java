package br.ifb.tsi.poo.robot.model.skills;

public abstract class Skill {
	public String toString() {
		String test = "";
		test += this.getClass().getSimpleName();
		
		return test;
	}
	
	public abstract int getCoast();
}
