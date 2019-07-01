package br.ifb.tsi.poo.robot.model.battles;

import br.ifb.tsi.poo.robot.model.robots.Fighter;

public class Tournament extends Battle{
	
	public Fighter winner;
	public Fighter looser;
	
	public Tournament() {
		super();
	}

	public Tournament(Fighter r1, Fighter r2) {
		super(r1, r2);
	}

	@Override
	
	public void start(String batalha) {
		int shift = 0;
		while(r1.isAlive() && r2.isAlive()) {
			r1.attack(r2);
			r2.attack(r1);
			System.out.println("Batalha" + batalha + "Turno "+ ++shift);
			System.out.println(r1);
			System.out.println(r2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(r1.isAlive()) {
			System.out.println(r1+" foi o vencedor!");
			setWinner(r1);
			setLooser(r2);
		}else if(r2.isAlive()) {
			System.out.println(r2+" foi o vencedor!");
			setWinner(r2);
			setLooser(r1);
		} else {
			System.out.println("EMPATE!");
			
		}
		
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Fighter getWinner() {
		return winner;
	}

	public void setWinner(Fighter winner) {
		this.winner = winner;
	}
	@Override
	public Fighter getLooser() {
		return looser;
	}

	public void setLooser(Fighter looser) {
		this.looser = looser;
	}
	
	
}
