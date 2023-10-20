package handlers;
import items.*;
import utilities.Utilities;
import world.*;

//Class to handle game interactions
public class GameInteractionHandler {
	//Method to use keys on objects
	public void attemptKey(Keys key, ObjectInRoom object) {
		//If used on door
		if (object instanceof Door) {
			Door door = (Door) object;
			
			if (door.isLocked()) {
				//Attempt to unlock with key
				door.unlockWithKey(key);
			} else {
				String message = "The " + door.getName() + " is already unlocked.";
				Utilities.slowPrint(message);
			}
		} else if (object instanceof Chest) {
			//TODO - Chest logic
		} else {
			Utilities.slowPrint("You can't use that here.");
		}
	}
}
