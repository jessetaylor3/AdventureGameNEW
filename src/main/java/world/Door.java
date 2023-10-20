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
		//Logic for interacting with the door
		if (this.isLocked) {
			Utilities.slowPrint("\nThe door is locked. You need the right key to open it");
		} else {
			Utilities.slowPrint("\nYou open the door and proceed through.");
		}
	}
}
