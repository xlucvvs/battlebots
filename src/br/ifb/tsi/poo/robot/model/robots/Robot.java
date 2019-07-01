package br.ifb.tsi.poo.robot.model.robots;


import java.util.Random;

import br.ifb.tsi.poo.robot.model.robots.Fighter;
import br.ifb.tsi.poo.robot.model.robots.parts.Part;

public class Robot implements Fighter{
	private int health;
	private String name;
	
	private Part head;
	private Part body;
	private Part leftArm;
	public Part rightArm;
	private Part legs;
	
	private int svhealth;
	private String svname;
		
	private Part svhead;
	private Part svbody;
	private Part svleftArm;
	private Part svrightArm;
	private Part svlegs;
		
		
	public Robot() {
		super();
		
		this.name = "Null";
		this.health = 10;
		this.head = new Part(0,0,0,0);
		this.body = new Part(0,0,0,0);
		this.legs = new Part(0,0,0,0);
		this.leftArm = new Part(0,0,0,0);
		this.rightArm = new Part(0,0,0,0);
		}

	public Robot(String name, Part head, Part body, Part leftArm, Part rightArm, Part legs) {
		super();
		this.name = name;
		this.health = 100;
		this.head = head;
		this.body = body;
		this.leftArm = leftArm;
		this.rightArm = rightArm;
		this.legs = legs;
		
		save();
	}

	private int getAttack(){
		int damage = 0;
		damage += leftArm.getAttack();
		damage += rightArm.getAttack();
		damage += legs.getAttack();
		damage += body.getAttack();
		damage += head.getAttack();
		return damage;
	}
	@Override
	public void attack(Fighter alvo) {
		int damage = this.getAttack();
		alvo.defend(damage);
	}
	
	public int getDefense() {
		int defense = 0;
		defense += leftArm.getDefense();
		defense += rightArm.getDefense();
		defense += legs.getDefense();
		defense += body.getDefense();
		defense += head.getDefense();
		return defense;
	}
		
	public int setDefense(int value) {
		int defense = value;
		defense += leftArm.getDefense();
		defense += rightArm.getDefense();
		defense += legs.getDefense();
		defense += body.getDefense();
		defense += head.getDefense();
		
		return defense;
	}
	
	@Override
	public void defend(int damage) {
		int defense, damageTaken = 0;
		defense = this.getDefense();
		
		if(damage > defense) {
			damageTaken = damage - defense;
			this.health -= damageTaken;
		}
		this.reduceSkill(damageTaken);
	}
		
	private void reduceSkill(int dano) {
		Random rand = new Random();
		int sortition = rand.nextInt(10) + dano;
		if(sortition > 5) {
			switch (rand.nextInt(5)) {
			case 0:
				this.getHead().reduceDurability();
				break;
			case 1:
				this.getBody().reduceDurability();
				break;
			case 2:
				this.getLegs().reduceDurability();
				break;
			case 3:
				this.getRightArm().reduceDurability();
				break;
			case 4:
				this.getLeftArm().reduceDurability();
				break;
			default:
				break;
			}
		}
	}
		
	public boolean isAlive() {
		boolean working = this.rightArm.works() ||this.leftArm.works() ||this.head.works() ||this.body.works() || this.legs.works();
		return (health > 0 && working);
	}

	public int getHealth() {
	return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}

	public Part getHead() {
		return head;
	}

	public void setHead(Part head) {
		this.head = head;
	}

	public Part getBody() {
		return body;
	}

	public void setBody(Part body) {
		this.body = body;
	}

	public Part getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Part leftArm) {
		this.leftArm = leftArm;
	}

	public Part getRightArm() {
		return rightArm;
	}

	public void setRightArm(Part rightArm) {
		this.rightArm = rightArm;
	}

	public Part getLegs() {
		return legs;
	}

	public void setLegs(Part legs) {
		this.legs = legs;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String parts = "";
		if(this.getHead().works()) { parts +="[C]";} else { parts +="[X]";}
		if(this.getBody().works()) { parts +="[T]";} else { parts +="[X]";}
		if(this.getLegs().works()) { parts +="[P]";} else { parts +="[X]";}
		if(this.getLeftArm().works()) { parts +="[BE]";} else { parts +="[X]";}
		if(this.getRightArm().works()) { parts +="[BD]";} else { parts +="[X]";}
		return "Robo " + name +": S=" + health + " A="+this.getAttack()+" D="+this.getDefense()+" Peças="+parts; 
	}

	@Override
	public void enableDefense() {
		// TODO Auto-generated method stub
	}

		@Override
	public void disableDefense() {
		// TODO Auto-generated method stub		
	}
		
		
		
	@Override
	public void reset() {
		this.name = this.svname;
		this.health = this.svhealth;
		this.head = this.svhead;
		this.body = this.svbody;
		this.legs = this.svlegs;
		this.leftArm = this.svleftArm;
		this.rightArm = this.svrightArm;
			
	}
	@Override
	public void save() {
		this.svname = getName();
		this.svhealth = getHealth();
		this.svhead = getHead();
		this.svbody = getBody();
		this.svlegs = getLegs();
		this.svleftArm = getLeftArm();
		this.svrightArm = getRightArm();
	}
		
}
