package rooms;

public class DragonsLair extends Room {
	//Static variable single_instance of type DragonsLair
	private static DragonsLair single_instance = null;
	
	//Additional properties
	
	//Get instance
	public static DragonsLair getInstance() {
		if (single_instance == null)
			single_instance = new DragonsLair();
		
		return single_instance;
	}
	
	//Dragon Lair constructor
    private DragonsLair() {
        super("Dragon's Lair", "A large cavern with scorched walls, the air inside is hot and smells of sulfur.");
        
    }
    
   
}
