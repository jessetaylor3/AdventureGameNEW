package entities;

//SUBCLASSES
public class Goblin extends Enemy{
	public Goblin() {
		super("Goblin", 50, 10); //Set goblin name, health, strength
	}
	
	@Override
	public String attackMessage() {
		return "The Goblin swings his rusty sword at you.";
	}
}
