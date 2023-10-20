package handlers;
import entities.*;
import items.Item;
import utilities.*;

public class ItemHandler {
	
	//Static method to handle logic for Player interacting with object
	public static void manageItem(Item item, Player player, InputHandler inputHandler) {
		while (true) {
			//Display inventory item selected and relevant options
			String message = "\nYou selected: " + item.getName() + ".\n";
			Utilities.slowPrint(message);
			System.out.println("1. Use");
			System.out.println("2. Equip");
			System.out.println("3. Drop");
			System.out.println("4. Return to inventory");
			
			//Get userInput
			String userInput = inputHandler.getUserInput();
			
			//Logic for decision making
			switch (userInput) {
			case "1":
				//Logic for using the item
				item.use(player); //The item should know how to use itself
				
				//Remove item from inventory if it's a one time use
				if (!item.isReusable()) {
					player.getInventory().removeItem(item);
				}
				return;
				
			case "2":
				//TODO -Logic for equipping items
				//equipItem(item, player) placeholder
				return;
			
			case "3":
				//Logic for dropping the item
				player.getInventory().removeItem(item);
				
				//Message for the dropped item
				message = "You dropped the " + item.getName() + ".";
				Utilities.slowPrint(message);
				return;
				
			case "4":
				//Return to previous inventory menu
				return;
				
			default:
				Utilities.slowPrint("Invalid option, please choose again.");
				break;
			}
		}
	}
	
	//Sub methods to be used in manageItem logic
	
}
