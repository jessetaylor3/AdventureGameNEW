package items;

public abstract class Item {
	//Attributes that all Item will use
	private String name;
	private String description;
	private boolean isReusable;
	
	//Constructor that doesn't explicitly set any attributes
	public Item(String name, String description, boolean isReusable) {
		this.name = name;
		this.description = description;
		this.isReusable = isReusable;
	}
	
	//Getters(for all Items)
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isReusable() {
		return isReusable;
	}
	
	//Abstract method to be implemented by subclass
	public abstract void use();
}
