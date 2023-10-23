package rooms;
import entities.*;
import items.*;
import world.*;
import handlers.*;
import java.util.List;
import java.util.ArrayList;
import utilities.Utilities;

public class ArmorRoom extends Room {
	//Static variable single instance of type ArmorRoom
	private static ArmorRoom single_instance = null;
	
	//Additional properties
	
	//Lists
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Get instance
	public static ArmorRoom getInstance() {
		if (single_instance == null)
			single_instance = new ArmorRoom();
		
		return single_instance;
	}
	
	//Armor room constructor
    public ArmorRoom() {
        super("Armor Room", "A room filled with various pieces of ancient and mystical armors.");
    this.itemsInRoom = new ArrayList<>();
    this.objectsInRoom = new ArrayList<>();
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
    	//TODO: INTRO, take into account room re-entering
    }
    
    //Method to exit
    @Override
    public void exitRoom(Player player, InputHandler inputHandler) {
    	Utilities.clearConsole();
    	Utilities.slowPrint(getDescription());
    	//TODO: INTRO 
    }
}
