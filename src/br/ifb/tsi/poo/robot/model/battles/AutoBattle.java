package br.ifb.tsi.poo.robot.model.battles;

import br.ifb.tsi.poo.robot.model.robots.Fighter;

public class AutoBattle extends Battle{
	public AutoBattle() {
		super();
	}

	public AutoBattle(Fighter r1, Fighter r2) {
		super(r1, r2);
	}

	@Override
	public void start() {
		int shift = 0;
		while(r1.isAlive() && r2.isAlive()) {
			r1.attack(r2);
			r2.attack(r1);
			System.out.println("Turno "+ ++shift);
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
		}else if(r2.isAlive()) {
			System.out.println(r2+" foi o vencedor!");
		} else {
			System.out.println("EMPATE!");
		}
	}

}
