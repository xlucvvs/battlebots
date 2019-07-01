package br.ifb.tsi.poo.robot.model.battles;

import java.util.Scanner;

import br.ifb.tsi.poo.robot.model.robots.Fighter;


public class ManualBattle extends Battle{
	Scanner teclado;
	public ManualBattle () {
		super();
		teclado = new Scanner(System.in);
	}

	public ManualBattle(Fighter r1, Fighter r2) {
		super(r1, r2);
		teclado = new Scanner(System.in);
	}
	
	@Override
	public void start() {
		int turno = 0;
		while(r1.isAlive() && r2.isAlive()) {
			((Fighter)r1).disableDefense();
			((Fighter)r2).disableDefense();
			
			System.out.println("Turno "+ turno++);
			System.out.println(r1);
			System.out.println(r2);
			
			int optr1 = this.escolherAtaque(r1, r2);
			int optr2 = this.escolherAtaque(r2, r1);
			
			if(optr1 == 2) {
				((Fighter)r1).enableDefense();
			}
			if(optr2 == 2) {
				((Fighter)r2).enableDefense();
			}
			
			
			if (optr1 == 1) {
				r1.attack(r2);
			}else if(optr1 != 2){
				System.out.println("Op��o Inv�lida.");
			}
			
			if (optr2 == 1) {
				r2.attack(r1);
			}else if(optr2 != 2){
				System.out.println("Op��o Inv�lida.");
			}
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(r1.isAlive()) {
			System.out.println("VENCEDOR:\n"+r1);
		}else if(r2.isAlive()) {
			System.out.println("VENCEDOR:\n"+r2);
		} else {
			System.out.println("EMPATE!");
		}
	}

	private int escolherAtaque(Fighter r1, Fighter r2) {
		System.out.println(r1.getName());
		System.out.println("Escolha o ataque:");
		System.out.println("1 - ataque normal");
		System.out.println("2 - defender");
		int opt = teclado.nextInt();
		return opt;
		
		
	}
}
