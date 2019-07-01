package br.ifb.tsi.poo.robot.model.constructors;

import java.util.Random;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.Robot;
import br.ifb.tsi.poo.robot.model.robots.parts.Part;


public class RandomRobotEngineer extends Coach{
	
	String name;
	Part head;
	Part body;
	Part legs;
	Part leftArm;
	Part rightArm;
	
	
	public Fighter trainFighter() {
		Random rand = new Random();
		String name = "Robo "+rand.nextInt(rand.nextInt(32)+1);
		Part head = new Part(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
		Part body = new Part(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
		Part legs = new Part(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
		Part leftArm = new Part(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
		Part rightArm = new Part(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
		
		this.name = name;
		this.head = head;
		this.body = body;
		this.legs = legs;
		this.leftArm = leftArm;
		this.rightArm = rightArm;
		
		return new Robot(name, head, body, leftArm, rightArm, legs);
	}
	
	
}
