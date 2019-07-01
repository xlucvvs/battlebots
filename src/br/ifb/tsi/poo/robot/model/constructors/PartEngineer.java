package br.ifb.tsi.poo.robot.model.constructors;

import java.util.Random;

import br.ifb.tsi.poo.robot.model.robots.parts.Part;

public class PartEngineer {
		public Part forgePart() {
			Random rand = new Random();
			int attack = 0, defense = 0, velocity = 0, durability = 0, durabilityBase = 1, n = 10;
			for (int i = 0; i < n; i++) {
				switch(rand.nextInt(4)) {
				case 0:		attack++;		break;
				case 1:		defense++;		break;
				case 2:		velocity++;		break;
				case 3:		durability++;	break;
				}
			}
			
			Part p = new Part(attack, defense, velocity, durabilityBase + durability);
			return p;
		}
}
