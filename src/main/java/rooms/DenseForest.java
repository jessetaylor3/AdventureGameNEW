package rooms;
import entities.*;
import items.*;
import world.*;
import handlers.*;
import java.util.List;
import java.util.ArrayList;
import utilities.Utilities;

public class DenseForest extends Room {
	//Static variables single instance of type DenseForest
	private static DenseForest single_instance = null;
	private GameMap gameMap;
	
	//Additional properties for room
	
	//Lists
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Get instance
	public static DenseForest getInstance(GameMap gameMap) {
		if (single_instance == null)
			single_instance = new DenseForest(gameMap);
		
		return single_instance;
	}
	
	//Constructor for dense forest
    private DenseForest(GameMap gameMap) {
        super("Dense Forest", "A dark, dense forest that seems to stretch on forever in every direction.");
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
    
    //Method to enter and run all
    @Override
    public void enterRoom(Player player, InputHandler inputHandler) {
    	Utilities.clearConsole();
    	Utilities.slowPrint(getDescription());
    	//TODO: INTRO
    }
    
    //Method to exit
    @Override
    public void exitRoom(Player player, InputHandler inputHandler, String direction) {
    	//TODO: Tree nook, crystal clearing, back to House?
    }
}
