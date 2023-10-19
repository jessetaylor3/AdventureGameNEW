package handlers;
import entities.*;
import items.*;
import utilities.Utilities;


public class InventoryHandler {
	//Static method so an instance of Inventory Handler doesn't need to be created
	public static void discoverItem(Item item, Inventory inventory, InputHandler inputHandler) {
		//Manage state of itemHandled
		boolean itemHandled = false;
		
		//Display message about finding item
		String message = "\nYou have found a " + item.getName() + ".";
		Utilities.slowPrint(message);
		
		//Display inventory decisions while item !Handled
		while (!itemHandled) {
			System.out.println("\n1. Pickup the " + item.getName() + ".");
			System.out.println("2. Leave the " + item.getName() + ".");
			System.out.println("3. Open inventory.");
			
			String userInput = inputHandler.getUserInput();
			
			//Process user choice
			switch (userInput) {
			case "1": //Try to pickup item
				boolean added = inventory.addItem(item);
				if (added) {
					message = "You have picked up the " + item.getName() + ".";
					Utilities.slowPrint(message);
					itemHandled = true;
				} else {
					Utilities.slowPrint("Your inventory is full.\n"
							+ "You can drop an item or leave this one behind.");
				}
				break;
			
			case "2": //Leave the item
				message = "You decided to leave the " + item.getName() + ".";
				Utilities.slowPrint(message);
				itemHandled = true;
				break;
				
			case "3": //Open inventory
				Utilities.slowPrint("Opening inventory...");
				//Logic for displaying and managing inventory
				
			default:
				Utilities.slowPrint("Invalid option, please choose again.");
				break;
			}
		}	
	}
	
	//Method to manage inventory items
	public static void manageInventory(Inventory inventory, InputHandler inputHandler) {
		while (true) {
			Utilities.slowPrint("\nInventory:\n");
			
			//Starting index
			int index = 1;
			
			//Loop to display inventory items
			for (Item item : inventory.getItems()) {
				System.out.println(index + ". " + item.getName());;
				index ++; //Iterate
			}
			
			//Fill the rest of the inventory slots with "Empty" if empty
			while (index <= Inventory.getMaxSlots()) {
				System.out.println(index + ". Empty");
				index ++; //Iterate
			}
			
			//Last option is return to previous menu
			System.out.println("5. Return\n");
			
			String userInput = inputHandler.getUserInput();
			
			//Convert userInput to integer for easier comparison and handling with inventory indexing
			int userChoice;
			try {
				userChoice = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				Utilities.slowPrint("Invalid input. Please enter a number.");
				continue;
			}
			
			//Handle logic of first menu (Items...Return)
			switch (userInput) {
			case "1":
				
			}
			
			
		}
	}
}











