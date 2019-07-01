package br.ifb.tsi.poo.robot.model.robots.parts;

public class Part {
	private int attack;
	private int defense;
	private int velocity;
	private int durability;
	
	public Part(int attack, int defense, int velocity, int durability) {
		super();
		this.attack = attack;
		this.defense = defense;
		this.velocity = velocity;
		this.durability = durability;
	}

	public int getAttack() {
		if (this.works()) {
			return attack;
		}
		return 0;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		if (this.works()) {
			return defense;
		}
		return 0;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getVelocity() {
		if (this.works()) {
			return velocity;
		}
		return 0;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	
	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	@Override
	public String toString() {
		return "Peça [A=" + attack + ", D=" + defense + ", Dur="+ durability +"]";
	}
	
	public boolean works() {
		return (durability > 0);
	}
	
	public void reduceDurability() {
		if(this.durability>0) {
			this.durability--;
		}
	}
}
