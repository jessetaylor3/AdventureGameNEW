package entities;

import utilities.Randomizer;
import utilities.Utilities;

//Abstract class Enemy which all will inherit from
public abstract class Enemy {
	private String name;
	private int health;
	private int strength;
	
	//Constructor for enemy class
	public Enemy(String name, int health, int strength) {
		this.name = name;
		this.health = health;
		this.strength = strength;
	}
	
	//Boolean to track alive status
	public boolean isAlive() {
		return health > 0;
	}
	
	//Method to randomize attackPower based on strength and random roll
	public int getAttackDamage() {
		int critMultiplier = 1; //Default crit value
		int missMultiplier = 1; //Default miss value
		
		//Generate the random crit roll
		int critRoll = Randomizer.randomNum(0, 100);
		
		//Generate the random miss roll
		int missRoll = Randomizer.randomNum(0, 100);
		
		//Logic for crit
		if (critRoll < 10) {
			critMultiplier = 2; //Double damage on 10% chance
			Utilities.slowPrint("Critical hit!");
		}
		
		//Logic for miss
		if (missRoll < 10) {
			missMultiplier = 0; //0 damage (miss) on 10% chance
			Utilities.slowPrint("The attack missed!");
		}
		
		//Calculate attack damage based on these factors
		int attackDamage = strength * critMultiplier * missMultiplier;
		
		//Return appropriate value
		return attackDamage;
	}
	
	//Method to take damage
	public void takeDamage(int damage) {
		//Subtract damage from enemy health
		health -= damage;
		
		//Create message to slow print with damage
		String message = "The " + name + " takes " + damage + " damage.";
		Utilities.slowPrint(message);
		
		//Check if alive
		if (isAlive()) {
			message = "The " + name + " has " + health + " health remaining.";
			Utilities.slowPrint(message);
		} else {
			message = "The " + name + " has been defeated.";
			Utilities.slowPrint(message);
		}
	}
	
	//Method to attack - not implemented
	public void attack(Player target) {
		getAttackDamage();
		//Player take damage?
		
	}
	
	//Attack message to be overwritten by subclasses
	public String attackMessage() {
		return "The enemy attacks!";
	}
	
	//Required getters/setters as needed
	public String getName() {
		return name;
	}
}

