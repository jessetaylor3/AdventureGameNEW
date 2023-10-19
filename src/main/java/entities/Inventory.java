package entities;
import utilities.*;
import handlers.*;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	//ArrayList to store inventory items
	private List<Item> items;
	
	//Max_slots
	private static final int MAX_SLOTS = 4;
	
	//Constructor for inventory
	public Inventory() {
		this.items = new ArrayList<>();
	}
	
	//Check if inventory is full and if not add item
	public boolean addItem(Item item) {
		if (items.size() < MAX_SLOTS) {
			items.add(item);
			return true; //Item added successfully
		} else {
			return false; //Inventory full
		}
	}
	
	//Method to remove item
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	//Getters as needed
	public List<Item> getItems(){
		return items;
	}
	
	public static int getMaxSlots() {
		return MAX_SLOTS;
	}
}
