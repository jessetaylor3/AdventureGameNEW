package rooms;
import entities.*;
import items.*;
import world.*;
import handlers.*;
import java.util.List;
import java.util.ArrayList;
import utilities.Utilities;

public class Backyard extends Room {
	//Static variable single instance of type Backyard
	private static Backyard single_instance = null;
	private GameMap gameMap;
	
	//Additional properties for room
	
	//Lists
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Get instance
	public static Backyard getInstance(GameMap gameMap) {
		if (single_instance == null)
			single_instance = new Backyard(gameMap);
		
		return single_instance;
	}
	
	//Backyard constructor
    private Backyard(GameMap gameMap) {
	    super("Backyard", "A peaceful open space behind the house, filled with overgrown grass and broken gardening tools.");
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
    
    //Method to run all
    @Override
    public void enterRoom(Player player, InputHandler inputHandler) {
    	Utilities.clearConsole();
    	Utilities.slowPrint(getDescription());
    	//TODO: INTRO, take into account room re-entering. State handlers?
    }
    
    @Override
    public void exitRoom(Player player, InputHandler inputHandler, String direction) {
    	//TODO: Back to house?
    }
}
