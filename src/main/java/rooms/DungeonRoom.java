package rooms;
import entities.*;
import handlers.*;
import utilities.*;
import java.util.HashMap;
import java.util.Map;

public class DungeonRoom extends Room {
	//Static variable single_instance of type DungeonRoom
	private static DungeonRoom single_instance = null;
	
	//Additional properties
	private boolean isThumbBroken;
	
	//Map holding items
//	private Map<String, Item> itemsInRoom;
	
	//Map holding possible directions
//	private Map<String, Room> connectedRooms;
	
	private DungeonRoom() {
		super("Dungeon", "This is a dark and scary dungeon.");
		this.isThumbBroken = false;
//		this.itemsInRoom = new HashMap<>();
//		this.connectedRooms = new HashMap<>();
	}
	
	//Static method to create instance of DungeonRoom class
	public static DungeonRoom getInstance() {
		if (single_instance == null)
			single_instance = new DungeonRoom();
		
		return single_instance;
	}
	
	
	@Override
	public void enterRoom(Player player, InputHandler inputHandler) {
		Utilities.clearConsole();
		Utilities.slowPrint(getDescription());
	}
	
	public boolean isThumbBroken() {
		return isThumbBroken;
	}
}
