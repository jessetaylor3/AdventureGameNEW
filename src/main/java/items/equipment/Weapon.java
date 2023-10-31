package items.equipment;

public class Weapon {
	//Attributes
	private String name;
	private String description;
	private int attackPower;
	
	//Constructor
	public Weapon(String name, String description, int attackPower) {
		this.name = name;
		this.description = description;
		this.attackPower = attackPower;
	}
	
	//Getters & setters
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getAttackPower() {
		return attackPower;
	}
}
