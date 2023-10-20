package world;
import items.*;
import utilities.*;
import handlers.*;
import entities.*;
import java.util.List;
import java.util.ArrayList;


public class Chest extends ObjectInRoom{
	//Extra attributes
	private boolean isLocked;
	private Keys key;
	private List<Item> itemsInside; //List for items stored in chest
	
	public Chest(String name, String description, boolean isLocked, Keys key, List<Item> itemsInside) {
		super(name, description);
		this.isLocked = isLocked;
		this.key = key;
		this.itemsInside = itemsInside;
	}
	
	public boolean isLocked() {
		return isLocked;
	}
	
	//Method to be unlocked by key
	public void unlockWithKey(Keys key) {
		if (this.key.equals(key)) {
			this.isLocked = false;
			String message = "\nYou used the " + key.getName() + " to unlock the chest.";
			Utilities.slowPrint(message);
		} else {
			Utilities.slowPrint("\nThis key doesn't fit the lock.");
		}
	}
	
	@Override
	public void interactWith(Player player, InputHandler inputHandler) {
	    // Logic for interacting with the chest
	    if (this.isLocked) {
	        Utilities.slowPrint("\nThe chest is locked. You need the right key to open it.");
	    } else {
	        // Check if the chest is empty
	        if (this.itemsInside.isEmpty()) {
	            Utilities.slowPrint("\nYou open the chest, but it's empty.");
	        } else {
	            Utilities.slowPrint("\nYou open the chest and look inside.");

	            // One more list to track items that were picked up and to be removed from chest
	            List<Item> itemsToRemove = new ArrayList<>();

	            // Iterate through items in chest
	            for (Item item : itemsInside) {
	                // Boolean to check if the method is successful
	                boolean wasPickedUp = InventoryHandler.discoverItem(item, player, inputHandler);
	                if (wasPickedUp) {
	                    itemsToRemove.add(item);
	                }
	            }

	            // Items that were picked up are removed from chest
	            itemsInside.removeAll(itemsToRemove);

	            // If all items were picked up and the chest is now empty, print a message.
	            if (itemsInside.isEmpty()) {
	                Utilities.slowPrint("\nYou've taken everything from the chest.");
	            }
	        }
	    }
	}

}
