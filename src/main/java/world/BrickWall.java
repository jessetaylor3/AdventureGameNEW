package world;
import items.*;
import handlers.*;
import utilities.*;
import entities.*;

public class BrickWall extends ObjectInRoom{
	private boolean brickRemoved;
	private Item hiddenItem;
	
	public BrickWall(String name, String description, Item hiddenItem) {
		super(name, description);
		this.brickRemoved = false; //Initially the brick is not removed
		this.hiddenItem = hiddenItem; //Item hidden behind brick
	}
	
	public boolean isBrickRemoved() {
		return brickRemoved;
	}
	
	@Override
	public void interactWith(Player player, InputHandler inputHandler) {
	    //Logic for interacting with secret brick
	    if (!brickRemoved) {
	        Utilities.slowPrint("\nIt's just a cold brick wall, this can't be any help.");

	        while (true) { // This will keep looping until a valid input is received
	            Utilities.slowPrint("Do you want to investigate further? (Y/N)");
	            String userInput = inputHandler.getUserInput().trim(); // trim() to remove any leading or trailing whitespace

	            if (userInput.equalsIgnoreCase("Y")) {
	                //Logic for removing the brick and discovering the item
	                this.brickRemoved = true;
	                Utilities.slowPrint("You feel the cold bricks with your hands, you notice one is loose.");
	                Utilities.slowPrint("You remove the brick, revealing a hidden compartment.");
	                boolean wasPickedUp = InventoryHandler.discoverItem(hiddenItem, player, inputHandler);
	                
	                if (wasPickedUp) {
	                    //Set item to null if it was picked up by the player
	                    this.hiddenItem = null;
	                }
	                break; // Exit the loop after valid input and action
	            } else if (userInput.equalsIgnoreCase("N")) {
	                Utilities.slowPrint("\nYou really know how to quit while you're behind.");
	                break; // Exit the loop after valid input and action
	            } else {
	                Utilities.slowPrint("Invalid input. Please enter 'Y' for yes or 'N' for no.");
	                // Loop will continue because neither 'Y' nor 'N' was entered
	            }
	        }
	    } else if (hiddenItem != null) {
	        //If the brick is removed and the item is still there
	        Utilities.slowPrint("\nThere's still something in the hidden compartment");
	        boolean wasPickedUp = InventoryHandler.discoverItem(hiddenItem, player, inputHandler);
	        
	        if (wasPickedUp) {
	            this.hiddenItem = null;
	        }
	    } else {
	        //If the brick and item are both gone
	        Utilities.slowPrint("\nThe hidden compartment in the wall is empty.");
	    }
	}


}
