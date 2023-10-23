package rooms;
import entities.*;
import items.*;
import world.*;
import handlers.*;
import java.util.List;
import java.util.ArrayList;
import utilities.Utilities;

public class MountainRange extends Room {
	//Static variable single instance of type MountainRange
	private static MountainRange single_instance = null;
	
	//Additional properties
	
	//Lists
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Get instance
	public static MountainRange getInstance() {
		if (single_instance == null)
			single_instance = new MountainRange();
		
		return single_instance;
	}
	
	//MountainRange constructor
    public MountainRange() {
        super("Mountain Range", "A breathtaking range of tall mountains that seems to touch the sky.");
        this.itemsInRoom = new ArrayList<>();
        this.objectsInRoom = new ArrayList<>();
        setupRoom();
    }
    
    //Method to setup room
    private void setupRoom() {
    	//TODO: Create items in room
    	
    	//TODO: Create objects for room
    	
    	//TODO: Put items and objects in the proper arrays
    }
    
    //Method to enter room(run all)
    @Override
    public void enterRoom(Player player, InputHandler inputHandler) {
    	Utilities.clearConsole();
    	Utilities.slowPrint(getDescription());
    	//TODO: INTRO. Take into account room re-entering. State handlers
    }
    
    //Method to exit room
    @Override
    public void exitRoom(Player player, InputHandler inputHandler) {
    	//TODO: Crystal clearing, dragons lair
    }
}
