package br.ifb.tsi.poo.robot.model.constructors;

import java.util.Scanner;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.Robot;
import br.ifb.tsi.poo.robot.model.robots.parts.Part;

public class InteractiveRobotEngineer extends Coach {
	private Scanner keyboard;

	public InteractiveRobotEngineer() {
		super();
		this.keyboard = new Scanner(System.in);
	}

	public Fighter trainFighter() {
		Robot r = new Robot();
		r.setHealth(100);
		System.out.println("Digite o nome do Robo:");
		r.setName(keyboard.nextLine());
		r.setHead(choosePart("Cabeça"));
		r.setBody(choosePart("Tronco"));
		r.setLegs(choosePart("Pernas"));
		r.setRightArm(choosePart("Braço Direito"));
		r.setLeftArm(choosePart("Braço Esquerdo"));
		return r;
	}
	
	private Part choosePart(String namePart) {
		PartEngineer engineer = new PartEngineer();
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
