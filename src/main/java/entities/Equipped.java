package entities;
import items.*;


public class Equipped {
	//Fields for each type of equipped item
	private Item weapon;
	private Item armor;
	private Item accessory; 
	
	//Constructor for equippedItems
	public Equipped() {
		this.weapon = null;
		this.armor = null;
		this.accessory = null;
	}

}
