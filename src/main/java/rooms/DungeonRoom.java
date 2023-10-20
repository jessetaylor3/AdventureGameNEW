package rooms;
import entities.*;
import handlers.*;
import utilities.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import items.*;
import world.*;

public class DungeonRoom extends Room {
	//Static variable single_instance of type DungeonRoom
	private static DungeonRoom single_instance = null;
	
	//Additional properties
	private boolean isThumbBroken;
	
	//List for items and objects in room
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Map holding possible directions
//	private Map<String, Room> connectedRooms;
	
	//Static method to create instance of DungeonRoom class
	public static DungeonRoom getInstance() {
		if (single_instance == null)
			single_instance = new DungeonRoom();
		
		return single_instance;
	}
	
	//DungeonRoom Constructor
	private DungeonRoom() {
		super("Dungeon", "This is a dark and scary dungeon.");
		this.isThumbBroken = false;
		
		//Initialize the items and objects in the room
		this.itemsInRoom = new ArrayList<>();
		this.objectsInRoom = new ArrayList<>();
		setupRoom();
	}
	
	//Method to setup items and objects in room
	private void setupRoom() {
		//Create items
		Keys smallKey = new Keys("Small Key", "It's what it says it is...");
		//Add items to itemsInRoom
		itemsInRoom.add(smallKey);
		
		//Create objects
		
		//Chest creation
		List<Item> itemsInChest = new ArrayList<>();
//		Item goldCoin = new Item("Gold Coin", "A shiny gold coin.");
		//TODO - This is just a filler key item for the chest to test code
		Item largeKey = new Keys("Large Key", "It describes itself.");
		itemsInChest.add(largeKey);
		
		Chest smallChest = new Chest(
				"Small Chest",
				"a small steel chest with a lock.",
				true,
				smallKey,
				itemsInChest
				);
		//Add all room objects and chest(s)
		objectsInRoom.add(smallChest);
	}
	
	//THIS METHOD WILL EVENTUALLY RUN ALL ROOM METHODS
	@Override
	public void enterRoom(Player player, InputHandler inputHandler) {
		Utilities.clearConsole();
		Utilities.slowPrint(getDescription());
		intro(player, inputHandler);
	}
	
	//Room Introduction
	private void intro(Player player, InputHandler inputHandler) {
		Utilities.slowPrint("You wake up on a cold stone floor. It's dark,"
				+ " and you realize your hands are handcuffed behind your back.");
		Utilities.slowPrint("What would you like to do?");
		System.out.println("\n1. Look around\n2. Check pockets\n3. Try to slip out of handcuffs");
		
		//Process user choice
		String userInput = inputHandler.getUserInput();
		switch (userInput) {
		case "1":
			lookAround();
			break;
			
		case "2":
			Utilities.slowPrint("It's hard to do this in handcuffs, but you don't feel anything in your pockets");
			break;
			
		case "3":
			//TODO attemptToSlipHandcuffs(player, inputHandler);
			break;
			
		default:
			Utilities.slowPrint("Invalid choice. Please try again.");
			intro(player, inputHandler); //Repeat loop if choice was invalid
			break;
		}
	}
	
	//Look around method
	private void lookAround() {
		Utilities.slowPrint("\nIt's too dark to see much, but you can just barely make out some shapes in the darkness...");
		for (ObjectInRoom object : this.objectsInRoom) {
			String message = "You see a " + object.getDescription() + ".";
			Utilities.slowPrint(message);
		}
		
	}
	
	
	
	//Getters and Setters
	public boolean isThumbBroken() {
		return isThumbBroken;
	}
}
