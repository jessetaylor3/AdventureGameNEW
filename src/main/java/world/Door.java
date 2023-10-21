package world;
import items.*;
import utilities.*;
import entities.*;
import handlers.*;

public class Door extends ObjectInRoom{
	//Attributes
	private boolean isLocked; //To monitor door locked status
	private Keys key;
	
	public Door(String name, String description, boolean isLocked, Keys key) {
		super(name, description);
		this.isLocked = isLocked;
		this.key = key; //The specific key that can unlock this door
	}
	
	public boolean isLocked() {
		return isLocked;
	}
	
	//Method to be unlocked by key
	public void unlockWithKey(Keys key) {
		if (this.key.equals(key)) {
			this.isLocked = false;
			String message = "\nYou used the " + key.getName() + " to unlock the door.";
			Utilities.slowPrint(message);
		} else {
			Utilities.slowPrint("\nThis key doesn't fit the lock.");
		}
	}
	
	@Override
	public void interactWith(Player player, InputHandler inputHandler) {
	    // Logic for interacting with the door
	    if (this.isLocked) {
	        boolean keyFound = false;
	        for (Item item : player.getInventory().getItems()) {
	            if (item instanceof Keys) {
	                Keys key = (Keys) item;
	                if (this.key.equals(key)) { 
	                    unlockWithKey(key);
	                    keyFound = true;
	                    break;
	                }
	            }
	        }
	        if (!keyFound) {
	            Utilities.slowPrint("\nThe door is locked, and you don't have the right key.");
	        }
	    } else {
	        Utilities.slowPrint("\nYou open the door and proceed through.");
	    }
	}

}
