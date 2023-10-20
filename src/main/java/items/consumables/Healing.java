package items.consumables;
import utilities.*;
import entities.*;
import items.*;

public class Healing extends Item {
	private boolean isReusable;
	private int healing;
	
	//Constructor for healing item
	public Healing(String name, String description, boolean isReusable, int healing) {
		super(name, description, isReusable);
		this.healing = healing;
	}
	
	public boolean isReusable() {
		return isReusable;
	}
	
	//Method for healing items
	@Override
	public void use(Player player) {
		String message = "You use the " + getName() + ".";
		Utilities.slowPrint(message);
		player.heal(healing);
	}
	
}
