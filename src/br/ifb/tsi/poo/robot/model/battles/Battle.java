package br.ifb.tsi.poo.robot.model.battles;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.Robot;

public abstract class Battle {
	protected Fighter r1;
	protected Fighter r2;
	protected Fighter winner;
	protected Fighter looser;
	
	public Battle() {
		super();
		this.r1 = new Robot();
		this.r2 = new Robot();
	}

	public Battle(Fighter r1, Fighter r2) {
		super();
		this.r1 = r1;
		this.r2 = r2;
	}
	
	public abstract void start();

	public void setR1(Fighter r1) {
		this.r1 = r1;
	}

	public void setR2(Fighter r2) {
		this.r2 = r2;
	}
	

	public Fighter getWinner() {
		return winner;
	}

	public void setWinner(Fighter winner) {
		this.winner = winner;
	}

	public Fighter getLooser() {
		return looser;
	}

	public void setLooser(Fighter looser) {
		this.looser = looser;
	}

	public void start(String batalha) {
		// TODO Auto-generated method stub
		
	}

	public Fighter getR1() {
		return r1;
	}

	public Fighter getR2() {
		return r2;
	}
	
	
	
}
