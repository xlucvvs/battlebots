package br.ifb.tsi.poo.robot.model.constructors;

import br.ifb.tsi.poo.robot.model.battles.Battle;
import br.ifb.tsi.poo.robot.model.robots.Fighter;


public class Referee {
	private Coach coach;
	private Battle battle;

	public Referee(Coach engineer, Battle battle) {
		super();
		this.coach = engineer;
		this.battle = battle;
	}

	public void callTheFighter() {
		
		Fighter r1 = coach.trainFighter();
		Fighter r2 = coach.trainFighter();
		
		this.battle.setR1(r1);
		this.battle.setR2(r2);
		battle.start();
	}
}