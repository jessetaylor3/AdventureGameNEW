package entities;
import items.*;

class EquippedItems{
	private Item weapon;
	private Item armor;
	private Item keyRing;
	
	public Item getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	
	public Item getArmor() {
		return armor;
	}
	
	public void setArmor(Item armor) {
		this.armor = armor;
	}
	
	public Item getKeyRing() {
		return keyRing;
	}
	
	public void setKeyRing(Item keyRing) {
		this.keyRing = keyRing;
	}
	
}