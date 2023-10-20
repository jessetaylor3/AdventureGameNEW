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
		Healing splint = new Healing("Splint", "a small splint used for bone fractures.", false, 0);
		
		//Would use itemsInRoom for items that are accessible. All items right now are hidden
		
		//Put some items in chest
		itemsInChest.add(largeKey);
		itemsInChest.add(splint);
		
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
				options = "TODO";
				break;
				
			case "chest":
				//Options when at chest
				options = "TODO";
				break;
				
			case "painting":
				//Options when at painting
				options = "TODO";
				break;
				
			case "wall":
				//Options when at brick wall
				options = "TODO";
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
				handleCenterChoices(userInput);
				return false; //Player stays in room
				
			case "door":
				//TODO
				
			case "chest":
				//TODO
				
			case "painting":
				//TODO
				
			case "wall":
				//TODO
				handleSpecificPositionChoices(userInput, player, inputHandler);
				return false; //Player stays in room
				
			default:
				Utilities.slowPrint("Invalid choice. Please select again.");
				return false;
			}
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
			player.takeDamage(10);
		} else {
			Utilities.slowPrint("\nYou decide to endure... the handcuffs remain on.");
		}
	}
	
	
	
	//Getters and Setters
	public boolean handcuffsOn() {
		return handcuffsOn;
	}
}
