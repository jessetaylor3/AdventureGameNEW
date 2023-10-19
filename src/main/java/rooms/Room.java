package rooms;
import utilities.*;
import handlers.*;
import entities.*;

public abstract class Room {
	private String description;
	private String name;
	
	public Room(String name, String description) {
		this.description = description;
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	//This will probably be overwritten everytime. 
	//Dont really see the point in abstraction here? Maybe with more planning
	public void enterRoom(Player player, InputHandler inputHandler) {
		Utilities.slowPrint(description);
	}
}
