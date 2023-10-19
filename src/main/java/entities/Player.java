package entities;
import java.util.ArrayList;
import java.util.List;
import utilities.Randomizer;
import utilities.Utilities;

//Player class for all player character functionality
public class Player {
	private String name;
	private int health;
	private int strength;
	private int armor;
	private Inventory inventory;
	
	//Player constructor
	public Player(String name) {
		this.name = name;
		this.health = 100;
		this.strength = 10;
		this.armor = 0;
		this.inventory = new Inventory();
	}
	
	//Boolean to track alive status
	public boolean isAlive() {
		return health > 0;
	}
	
	//Method to get attack damage of Player attack
	public int getAttackDamage() {
		//Default multipliers
		int critMultiplier = 1; //Default value
		int missMultiplier = 1; //Default value and will stay default for now(Player can't miss)
		
		//Generate a random number for critical chance
		int critRoll = Randomizer.randomNum(0, 100);
		
		//Logic for roll
		if (critRoll < 10) {
			critMultiplier = 3; //Triple damage with 10% chance
			Utilities.slowPrint("Triple damage bonus!");
		} else if (critRoll < 30) {
			critMultiplier = 2; //Double damage with 30% chance
			Utilities.slowPrint("Double damage bonus!");
		}
		
		//Calculate damage
		int attackDamage = strength * critMultiplier * missMultiplier;
		
		//Return appropriate value
		return attackDamage;
	}
	
	//Method for Player to take damage
	public void takeDamage(int damage) {
		//Subtract damage from Player health less armor
		int reducedDamage = Math.max(0, damage - armor);
		health -= reducedDamage;
		
		//Display message with damage taken if alive
		if (isAlive()) {
			String message = "\nYou've lost " + reducedDamage + " health.\n"
					+ "Remaining health: " + health;
			Utilities.slowPrint(message);
		} else { //If not alive print GAME OVER message
			Utilities.clearConsole();
			Utilities.slowPrint("\nYou died. The game is over.\n);"
					+ "RIP RICKY");
		}
	}
	
	//Attack message
	public String attackMessage(Enemy enemy) {
		return "\nYou attack the " + enemy.getName() + "."; 
	}
	
	//Getters and setters where needed
	public String getName() {
		return name;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
}
