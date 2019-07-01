package br.ifb.tsi.poo.robot.model.battles;

import java.util.Random;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;

public class AutoSkillBattle extends Battle {
	
	Random rand = new Random();
	int teclado;
	
	public AutoSkillBattle() {
		super();
	}

	public AutoSkillBattle(Fighter r1, Fighter r2) {
		super(r1, r2);
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
				System.out.println("Opção Invalida.");
			}
			
			if (optr2 == 1) {
				r2.attack(r1);
			}else if(optr2 == 3 && r2 instanceof SkillRobot) {
				this.useSkill(r2, r1, optH2);
			}else if(optr2 != 2){
				System.out.println("Opção Invalida.");
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
		int opt2 = 0;
		
		SkillRobot r1h = (SkillRobot) r1;
		
		if(r1h.getSkills().size() == 5) {
			opt2 = (rand.nextInt(5)+1);
		}else if(r1h.getSkills().size() == 4) {
			opt2 = (rand.nextInt(4)+1);
		} else if(r1h.getSkills().size() == 3) {
			opt2 = (rand.nextInt(3)+1);
		} else if(r1h.getSkills().size() == 2) {
			opt2 = (rand.nextInt(2)+1);
		} else {
			opt2 = 1;
		}
		
		return opt2;
		
	}

	private int chooseAttack(Fighter r1, Fighter r2) {
		int opt = 0;
		if(r1 instanceof SkillRobot & ((SkillRobot)r1).getSkills().size() > 0) {
			opt = (rand.nextInt(3)+1);
		} else {
			opt = (rand.nextInt(2)+1);
		}
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
