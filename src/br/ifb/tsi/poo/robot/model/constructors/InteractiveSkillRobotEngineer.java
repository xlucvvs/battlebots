package br.ifb.tsi.poo.robot.model.constructors;

import java.util.Scanner;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.SkillRobot;
import br.ifb.tsi.poo.robot.model.robots.parts.Part;

public class InteractiveSkillRobotEngineer extends Coach {
	private Scanner keyboard;

	public InteractiveSkillRobotEngineer() {
		super();
		this.keyboard = new Scanner(System.in);
	}

	@Override
	public Fighter trainFighter() {
		
		
		System.out.println("Digite o nome do Robo:");
		String name = keyboard.nextLine();
		Part head = choosePart("Cabeça");
		Part body = choosePart("Tronco");
		Part legs = choosePart("Pernas");
		Part rightArm = choosePart("Braço Direito");
		Part leftArm = choosePart("Braço Esquerdo");
		SkillRobot r = new SkillRobot(name, head, body, leftArm, rightArm, legs);
		r.setHealth(100);
		return r;
	}
	
	private Part choosePart(String namePart) {
		PartEngineer engineer = new SkillPartEngineer();
		Part p1 = engineer.forgePart();
		Part p2 = engineer.forgePart();
		Part p3 = engineer.forgePart();
		
		System.out.println("Escolha o "+namePart);
		System.out.println("1 - "+p1);
		System.out.println("2 - "+p2);
		System.out.println("3 - "+p1);
		String opt = keyboard.nextLine();
		switch(opt) {
		case "1": return p1; 
		case "2": return p2; 
		case "3": return p3; 
		}
		return p1;
	}
}
