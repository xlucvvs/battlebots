package br.ifb.tsi.poo.robot.model.robots;

import br.ifb.tsi.poo.robot.model.robots.Fighter;

public interface Fighter {
	public void attack(Fighter fighter);
	public void defend(int dano);
	public boolean isAlive();
	public String getName();

	public void enableDefense();
	public void disableDefense();
	public void reset();
	public void save();
}