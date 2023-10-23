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
	
    public MountainRange() {
        super("Mountain Range", "A breathtaking range of tall mountains that seems to touch the sky.");
    }
}
