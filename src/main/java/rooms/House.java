package rooms;
import items.*;
import utilities.*;
import entities.*;
import handlers.*;
import java.util.List;
import java.util.ArrayList;
import world.*;

public class House extends Room {
	private static House single_instance = null;
	private GameMap gameMap;
	
	//Additional properties
	private String playerPosition;
	
	//List for items and objects in room
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Static method to create instance of House
	public static House getInstance(GameMap gameMap) {
		if (single_instance == null)
			single_instance = new House(gameMap);
		
		return single_instance;
	}
	
	//House constructor
	private House(GameMap gameMap) {
		super("House", "This is an old house, with crumbling walls and a leaky roof.\nIt looks like goblins have been living here.");
		this.itemsInRoom = new ArrayList<>();
		this.objectsInRoom = new ArrayList<>();
		this.playerPosition = "the top of the stairs";
		this.gameMap = gameMap;
		setupRoom();
	}
	
	//Method to setup room
	private void setupRoom() {
		//TODO: Create items for room
		
		//TODO: Create objects for room 
		
		//TODO: Put items and objects in proper Arrays
	}
	
	//Method to run all
	@Override
	public void enterRoom(Player player, InputHandler inputHandler) {
		Utilities.clearConsole();
		Utilities.slowPrint(getDescription());
		//TODO Intro()
	}
	
	@Override
	public void exitRoom(Player player, InputHandler inputHandler, String direction) {
		//TODO: Backyard, or dense forest
		Utilities.slowPrint("You leave the room");
	}
}
