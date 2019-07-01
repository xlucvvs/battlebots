package br.ifb.tsi.poo.robot.model.battles;

import java.util.Scanner;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;
import br.ifb.tsi.poo.robot.model.skills.Skill;

public class ManualSkillBattle extends Battle {
	Scanner keyboard;
	public ManualSkillBattle() {
		super();
		keyboard = new Scanner(System.in);
	}

	public ManualSkillBattle(Fighter r1, Fighter r2) {
		super(r1, r2);
		keyboard = new Scanner(System.in);
	}
	
	@Override
	public void start() {
		int turno = 0;
		int optH1 = 0, optH2 = 0;
		while(r1.isAlive() && r2.isAlive()) {
			((SkillRobot)r1).disableDefense();
			((SkillRobot)r2).disableDefense();
			
			System.out.println("Turno "+ turno++);
			System.out.println(r1);
			System.out.println(r2);
			
			int optr1 = this.chooseAttack(r1, r2);
			if(optr1 == 3) {
				optH1 = this.chooseSkill(r1);
			}
			int optr2 = this.chooseAttack(r2, r1);
			if(optr2 == 3) {
				optH2 = this.chooseSkill(r2);
			}
			
			if(optr1 == 2) {
				((SkillRobot)r1).enableDefense();
			}
			if(optr2 == 2) {
				((SkillRobot)r2).enableDefense();
			}
			
			if (optr1 == 1) {
				r1.attack(r2);
			}else if(optr1 == 3 && r1 instanceof SkillRobot) {
				this.useSkill(r1, r2, optH1);
			}else if(optr1 != 2){
				System.out.println("Opção Inv�lida.");
			}
			
			if (optr2 == 1) {
				r2.attack(r1);
			}else if(optr2 == 3 && r2 instanceof SkillRobot) {
				this.useSkill(r2, r1, optH2);
			}else if(optr2 != 2){
				System.out.println("Opção Inv�lida.");
			}
			
			
			((SkillRobot) r1).recoverEnergy();
			((SkillRobot) r2).recoverEnergy();
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
	
	private int chooseSkill(Fighter r1) {
		System.out.println("Escolha a Habilidade:");
		int i = 1;
		SkillRobot r1h = (SkillRobot) r1;
		for (Skill h : r1h.getSkills()) {
			System.out.println(i++ +"-"+ h);
		}
		
		return keyboard.nextInt();
		
	}

	private int chooseAttack(Fighter r1, Fighter r2) {
		System.out.println(r1.getName());
		System.out.println("Escolha o ataque:");
		System.out.println("1 - ataque normal");
		System.out.println("2 - defender");
		if(r1 instanceof SkillRobot & ((SkillRobot)r1).getSkills().size() > 0) {
			System.out.println("3 - habilidade");
		}
		int opt = keyboard.nextInt();
		return opt;
		
		
	}
	private void useSkill(Fighter r1, Fighter r2, int opt) {
		SkillRobot r1h = (SkillRobot) r1;
		if(r1h.getSkills().size() >= opt & opt > 0) {
			r1h.apply(r1h.getSkills().get(opt-1), r2);
		}else {
			System.out.println("Habilidade escolhida nao disponivel.");
		}
		
		
	}
}
