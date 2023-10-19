package items;

import utilities.Utilities;

public class Keys extends Item {
//	private KeyType keyType;
	private boolean isReusable;
	
	//Constructor for smallKey
	public Keys(String name, String description) {
		super(name, description, false); 
	}
	
	public boolean isResuable() {
		return isReusable;
	}
	
	
	//Methods for Keys
	@Override
	public void use() {
		String message = "You use the " + getName() + " to unlock the chest?";
		Utilities.slowPrint(message);
	}
}
