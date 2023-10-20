package items;
import entities.*;
import utilities.Utilities;

public class Keys extends Item {
//	private KeyType keyType;
	private boolean isReusable;
	
	//Constructor for Key
	public Keys(String name, String description) {
		super(name, description, false); 
	}
	
	public boolean isResuable() {
		return isReusable;
	}
	
	
	//Methods for Keys
	@Override
	public void use(Player player) {
		String message = "You try to use the " + getName() + ".";
		Utilities.slowPrint(message);
	}
}
