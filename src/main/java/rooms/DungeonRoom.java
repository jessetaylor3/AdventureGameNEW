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
import items.consumables.Healing;

public class DungeonRoom extends Room {
	//Static variable single_instance of type DungeonRoom
	private static DungeonRoom single_instance = null;
	
	//Additional properties
	private boolean handcuffsOn;
	private String playerPosition; // center, door, chest, painting, wall
	
	//List for items and objects in room
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Static method to create instance of DungeonRoom class
	public static DungeonRoom getInstance() {
		if (single_instance == null)
			single_instance = new DungeonRoom();
		
		return single_instance;
	}
	
	//DungeonRoom Constructor
	private DungeonRoom() {
		super("Dungeon", "This is a dark and scary dungeon.");
		this.handcuffsOn = true; //Player starts with handcuffs
		this.itemsInRoom = new ArrayList<>(); //Initialize list for items in room
		this.objectsInRoom = new ArrayList<>(); //Initialize list for objects in room
		this.playerPosition = "center";
		setupRoom();
	}
	
	//Method to setup items and objects in room
	private void setupRoom() {
		List<Item> itemsInChest = new ArrayList<>();
		
		//Create items
		Keys largeKey = new Keys("Large Key", "It describes itself.");
		Keys smallKey = new Keys("Small Key", "It's what it says it is...");
		Healing splint = new Healing("Splint", "a small splint used for bone fractures.", false, 10);
		
		//Would use itemsInRoom for items that are accessible. All items right now are hidden
		
		//Put some items in chest
		itemsInChest.add(splint);
		itemsInChest.add(largeKey);
		
		//Create objects
		this.objectsInRoom.add(new Door("Old barred door", "heavy door with old bars and a large keyhole.", true, largeKey));
		this.objectsInRoom.add(new Painting("Dusty Painting", "dusty painting with a faded noble figure."));
		Chest smallChest = new Chest(
				"Small Chest",
				"small steel chest with a lock.",
				true,
				smallKey,
				itemsInChest
				);
		BrickWall brickWall = new BrickWall(
				"Brick Wall",
				"old brick wall.",
				smallKey);
				
		//Add all room objects and chest(s)
		objectsInRoom.add(smallChest);
		objectsInRoom.add(brickWall);
	}
	
	//THIS METHOD WILL EVENTUALLY RUN ALL ROOM METHODS
	@Override
	public void enterRoom(Player player, InputHandler inputHandler) {
		Utilities.clearConsole();
		Utilities.slowPrint(getDescription());
		intro(player, inputHandler);
		
		boolean playerWantsToLeave = false;
		while (!playerWantsToLeave) {
			String userInput = showOptions(inputHandler);
			playerWantsToLeave = processChoice(userInput, player, inputHandler);
		}
	}
	
	@Override
	public void exitRoom(Player player, InputHandler inputHandler) {
		//TODO: Enter House, enter back to dungeon?
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
			Utilities.slowPrint("\nIt's hard to do this in handcuffs, but you don't feel anything in your pockets");
			break;
			
		case "3":
			attemptToSlipHandcuffs(player, inputHandler);
			break;
			
		default:
			Utilities.slowPrint("Invalid choice. Please try again.");
			intro(player, inputHandler); //Repeat loop if choice was invalid
			break;
		}
	}
	
	//ShowOptions based on player specifics and pass this to processChoice method
	private String showOptions(InputHandler inputHandler) {
		String message = "You are at the " + this.playerPosition + ".\nWhat would you like to do?";
		Utilities.slowPrint(message);
		String options;
		
		//Logic for handcuffs still being on
		if (this.handcuffsOn) {
			options = "1. Try to slip out of handcuffs\n2. Scream for help\n3. Do nothing";
		} else {
			switch (this.playerPosition) {
			case "center":
				options = "1. Go forward to the door\n2. Go left to the chest\n3. Go backward to the painting\n"
						+ "4. Go right to the brick wall\n5. Look around\n6. Manage Inventory";
				break;
			
			case "door":
				//Options when at door
				options = "1. Try and open it\n2. Return to the center of the room\n3. Manage Inventory";
				break;
				
			case "chest":
				//Options when at chest
				options = "1. Try and open it\n2. Return to the center of the room\n3. Manage Inventory";
				break;
				
			case "painting":
				//Options when at painting
				options = "1. Inspect painting\n2. Return to the center of the room\n3. Manage Inventory";
				break;
				
			case "wall":
				//Options when at brick wall
				options = "1. Inspect the wall\n2. Return to the center of the room\n3. Manage Inventory";
				break;
				
			default:
				options = "Invalid position. This should never happen.";
				break;
			}
		}
		//Display options and get userInput
		System.out.println("\n" + options);
		String userInput = inputHandler.getUserInput();
		return userInput;
	}
	
	//ProcessChoice uses showOptions to gather userChoice
	private boolean processChoice(String userInput, Player player, InputHandler inputHandler) {
		if (this.handcuffsOn) {
			switch (userInput) {
			case "1":
				attemptToSlipHandcuffs(player, inputHandler);
				return false; //Player stays in room
			
			case "2":
				Utilities.slowPrint("You scream for help. But nobody comes...");
				return false; //Player stays in room
				
			case "3":
				Utilities.slowPrint("You do nothing...");
				return false; //Player stays in room
				
			default:
				Utilities.slowPrint("Invalid coice. Please select again.");
				return false; //Player stays in room
			}
		} else {
			switch (this.playerPosition) {
			case "center":
				//TODO
				handleCenterChoices(userInput, player, inputHandler);
				return false; //Player stays in room
				
			case "door":
				handleNonCenterChoices(userInput, player, inputHandler);
				return false;
				
			case "chest":
				handleNonCenterChoices(userInput, player, inputHandler);
				return false;
				
			case "painting":
				handleNonCenterChoices(userInput, player, inputHandler);
				return false;
				
			case "wall":
				handleNonCenterChoices(userInput, player, inputHandler);
				return false; //Player stays in room
				
			default:
				Utilities.slowPrint("Invalid choice. Please select again.");
				return false;
			}
		}
	}
	
	//Handles options for user when standing in center. (Changes player position)
	//TODO Display messages to user here?
	private void handleCenterChoices(String userInput, Player player, InputHandler inputHandler) {
		switch (userInput) {
		case "1":
			Utilities.slowPrint("You walk towards the heavy barred door.");
			this.playerPosition = "door";
			break;
			
		case "2":
			Utilities.slowPrint("You walk towards the small steel chest.");
			this.playerPosition = "chest";
			break;
			
		case "3":
			Utilities.slowPrint("You walk towards the old dusty painting.");
			this.playerPosition = "painting";
			break;
			
		case "4":
			Utilities.slowPrint("You walk towards the cold brick wall.");
			this.playerPosition = "wall";
			break;
			
		case "5":
			lookAround();
			break;
			
		case "6":
			InventoryHandler.manageInventory(player, inputHandler);
			break;
		}
	}
	
	//Logic for player when they're standing at a side of the room
	private void handleNonCenterChoices(String userInput, Player player, InputHandler inputHandler) {
		if ("1".equals(userInput)) {
			for (ObjectInRoom objectsInRoom : this.objectsInRoom) {
				if (objectsInRoom.getName().toLowerCase().contains(this.playerPosition)) {
					objectsInRoom.interactWith(player, inputHandler);
					return;
				}
			}
			Utilities.slowPrint("There's nothing to interact with here.");
		} else if ("2".equals(userInput)) {
			Utilities.slowPrint("You walk back to the center of the room.");
			this.playerPosition = "center";
		} else if ("3".equals(userInput)){
			InventoryHandler.manageInventory(player, inputHandler);
			
		} else {
			Utilities.slowPrint("Invalid choice. Please select again.");
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
	
	//Logic for breaking out of the handcuffs
	private void attemptToSlipHandcuffs(Player player, InputHandler inputHandler) {
		Utilities.slowPrint("\nYou try to slip the handcuffs. It's painful and they're tight");
		Utilities.slowPrint("\nWould you like to dislocate your thumb to try and escape? (Y/N)");
		if ("Y".equalsIgnoreCase(inputHandler.getUserInput())) {
			Utilities.slowPrint("\n....with a scream and a crack, you dislocate your thumb and your hands slip free!");
			this.handcuffsOn = false;
			player.takeDamage(30);
		} else {
			Utilities.slowPrint("\nYou decide to endure... the handcuffs remain on.");
		}
	}
	
	
	
	//Getters and Setters
	public boolean handcuffsOn() {
		return handcuffsOn;
	}
}
