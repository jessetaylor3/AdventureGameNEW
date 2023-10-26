package rooms;
import entities.*;
import items.*;
import world.*;
import handlers.*;
import java.util.List;
import java.util.ArrayList;
import utilities.Utilities;

public class GoblinsNook extends Room {
	//Static variable single instance of type Goblins
	private static GoblinsNook single_instance = null;
	private GameMap gameMap;
	
	//Additional properties for room
	
	//Lists
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Get instance
	public static GoblinsNook getInstance(GameMap gameMap) {
		if (single_instance == null)
			single_instance = new GoblinsNook(gameMap);
		
		return single_instance;
	}
	
	//Goblins nook constructor
    private GoblinsNook(GameMap gameMap) {
        super("Goblin's Nook", "A messy and smelly nook, clearly the living space of untidy goblins.");
        this.itemsInRoom = new ArrayList<>();
        this.objectsInRoom = new ArrayList<>();
        this.gameMap = gameMap;
        setupRoom();
    }
    
    //Method to setup room
    private void setupRoom() {
    	//TODO: Create items for room
    	
    	//TODO: Create objects for room
    	
    	//TODO: Put items and objects in proper arrays
    }
    
    //Method to enter room/run all
    @Override
    public void enterRoom(Player player, InputHandler inputHandler) {
    	Utilities.clearConsole();
    	Utilities.slowPrint(getDescription());
    	//TODO: INTRO
    }
    
    @Override
    public void exitRoom(Player player, InputHandler inputHandler, String direction) {
    	//TODO: Dense Forest
    }
}
