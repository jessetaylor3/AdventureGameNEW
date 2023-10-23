package rooms;
import entities.*;
import items.*;
import world.*;
import handlers.*;
import java.util.List;
import java.util.ArrayList;
import utilities.Utilities;

public class CrystalClearing extends Room {
	//Static variable single instance of type CrystalClearing
	private static CrystalClearing single_instance = null;
	
	//Additional properties for room
	
	//List
	private List<Item> itemsInRoom;
	private List<ObjectInRoom> objectsInRoom;
	
	//Get instance
	public static CrystalClearing getInstance() {
		if (single_instance == null)
			single_instance = new CrystalClearing();
		
		return single_instance;
	}
	
	//CrystalClearing constructor
    public CrystalClearing() {
        super("Crystal Clearing", "A mesmerizing clearing in the forest where the ground is covered in sparkling crystals.");
        this.itemsInRoom = new ArrayList<>();
        this.objectsInRoom = new ArrayList<>();
        setupRoom();
    }
    
    //Method to setup room
    private void setupRoom() {
    	//TODO: Create items for room
    	
    	//TODO: Create objects for room
    	
    	//TODO: Put items and objects in proper arrays
    }
    
    @Override
    public void enterRoom(Player player, InputHandler inputHandler) {
    	Utilities.clearConsole();
    	Utilities.slowPrint(getDescription());
    	//TODO: INTRO, take into account room re-entering. State handlers
    }
    
    @Override
    public void exitRoom(Player player, InputHandler inputHandler) {
    	//TODO:
    }
}
