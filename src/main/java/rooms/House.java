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
		roomInteractionLoop(player, inputHandler);
	}
	
	@Override
	public void exitRoom(Player player, InputHandler inputHandler, String direction) {
		Room nextRoom = null;
		
		switch (direction.toLowerCase()) {
		case "north":
			nextRoom = DungeonRoom.getInstance(gameMap);
			break;
			
		case "south":
			nextRoom = this.gameMap.getRoom(2, 1);
			break;
			
		case "east":
			nextRoom = this.gameMap.getRoom(1, 2);
			break;
		}
		
		nextRoom.enterRoom(player, inputHandler);
	}
	
	//Room interaction loop
	private void roomInteractionLoop(Player player, InputHandler inputHandler) {
		boolean wantsToLeave = false;
		
		while (!wantsToLeave){
			String choice = presentOptions(inputHandler);
			wantsToLeave = processChoice(choice, player, inputHandler);
		}
	}
	
	//Present room options
	private String presentOptions(InputHandler inputHandler) {
		//Present options based on player state and position
		String options;
		options = "1. Go upstairs\n2. Search the kitchen\n3. Go into the backyard\n4. Return to the dungeon";
		System.out.println("\n" + options);
		
		//Return user input
		return inputHandler.getUserInput();
	}
	
	//Process user choice/decision
	private boolean processChoice(String choice, Player player, InputHandler inputHandler) {
		//Process choice and return true if player wants to leave the room?
		switch (choice) {
		case "1":
			//TODO: Logic for going upstairs
			
			return false; //Player stays in room
			
		case "2":
			//TODO: Logic for searching kitchen
			
			return false; //Player stays in room
			
		case "3":
			//TODO: Additional logic for backyard door
			Utilities.slowPrint("You exit the house.");
			
			exitRoom(player, inputHandler, "east");
			return true; //Player left the room
		
		case "4":
			Utilities.slowPrint("You choose to return down the spiral stone steps into the dungeon..");
			exitRoom(player, inputHandler, "north");
			return true; //Player exits the room
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
