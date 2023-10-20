package world;
import entities.*;
import handlers.*;

public abstract class ObjectInRoom{
	private String name;
	private String description;
	
	public ObjectInRoom(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	//Meant to be overwritten by subclasses
	public abstract void interactWith(Player player, InputHandler inputHandler);
}