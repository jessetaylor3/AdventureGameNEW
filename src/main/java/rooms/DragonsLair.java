package rooms;
import entities.*;
import items.*;
import world.*;
import handlers.*;
import java.util.List;
import java.util.ArrayList;
import utilities.Utilities;

public class DragonsLair extends Room {
	//Static variable single_instance of type DragonsLair
	private static DragonsLair single_instance = null;
	private GameMap gameMap;
	
	//Additional properties
	
	//Lists
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Get instance
	public static DragonsLair getInstance(GameMap gameMap) {
		if (single_instance == null)
			single_instance = new DragonsLair(gameMap);
		
		return single_instance;
	}
	
	//Dragon Lair constructor
    private DragonsLair(GameMap gameMap) {
        super("Dragon's Lair", "A large cavern with scorched walls, the air inside is hot and smells of sulfur.");
        this.itemsInRoom = new ArrayList<>();
        this.objectsInRoom = new ArrayList<>();
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
    	//TODO: INTRO, take into account room re-entering. Might be state handlers
    	
    }
    
    @Override
    public void exitRoom(Player player, InputHandler inputHandler, String direction) {
    	Utilities.slowPrint("You leave the room");
    }
   
}
