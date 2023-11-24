 package handlers;
import entities.Player;
import entities.Enemy;
import utilities.Utilities;

public class CombatHandler {
	//Initiate combat between one Player and one Enemy
	public void startCombat(Player player, Enemy enemy, InputHandler inputHandler) {
		//Combat message
		String message = "You have entered combat with a " + enemy.getName() + ".";
		Utilities.slowPrint(message);
		
		//Implement combat logic
		while (player.isAlive() && enemy.isAlive()) {
			//Display combat options
			System.out.println("\n1. Attack");
			System.out.println("2. Attempt to roach out.");
			System.out.println("3. Use inventory item\n");
			
			//Get user input
			String userInput = inputHandler.getUserInput();
			
			//Process user choice
			switch (userInput) {
			case "1":
				//Player attacks enemy
				Utilities.slowPrint(player.attackMessage(enemy));
				int playerDamage = player.getAttackDamage(); //Get damage
				enemy.takeDamage(playerDamage);
				
				//Enemy attacks back
				if (enemy.isAlive()) {
					Utilities.slowPrint(enemy.attackMessage());
					int enemyDamage = enemy.getAttackDamage();
					player.takeDamage(enemyDamage);
				}
				break;
				
			case "2":
				//Flee logic
				Utilities.slowPrint("Your attempt to flee failed.");
				
				//Enemy attacks
				Utilities.slowPrint(enemy.attackMessage());
				int enemyDamage = enemy.getAttackDamage();
				player.takeDamage(enemyDamage);
				break;
				
			case "3":
				//Inventory logic
				Utilities.slowPrint("Your inventory is empty.");
				
				//Enemy attacks
				Utilities.slowPrint(enemy.attackMessage());
				enemyDamage = enemy.getAttackDamage();
				player.takeDamage(enemyDamage);
				break;
				
			default:
				//Invalid input logic
				Utilities.slowPrint("Invalid input, please try again.");
				break;
			}
			
			
		}
	}
}
