package rooms;
import items.*;
import java.util.List;
import java.util.ArrayList;
import world.*;

public class House extends Room {
	private static House single_instance = null;
	
	//Additional properties
	private String playerPosition;
	
	//List for items and objects in room
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Static method to create instance of House
	public static House getInstance() {
		if (single_instance = null)
			single_instance = new DungeonRoom();
		
		return single_instance;
	}
	
	//House constructor
	private House() {
		super("House", "This is an old house, with crumbling walls and a leaky roof.\nIt looks like goblins have been living here.");
		this.itemsInRoom = new ArrayList<>();
		this.objectsInRoom = new ArrayList<>();
		this.playerPosition = "the top of the stairs";
		setupRoom();
	}
	
	//Method to setup room
	private void setupRoom() {
		//TODO: Create items for room
		
		//TODO: Create objects for room 
		
		//TODO: Put items and objects in proper Arrays
		System.out.println("Test line");
	}
	
	//Method to run all
}
