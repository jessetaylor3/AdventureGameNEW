package handlers;
import rooms.*;

public class DirectionHandler {
	private GameMap gameMap;
	
	public DirectionHandler(GameMap gameMap) {
		this.gameMap = gameMap;
	}
	
	public Room getAdjacentRoom(int x, int y, String direction) {
		switch (direction.toLowerCase()) {
		
		case "north":
			return (y >0) ? gameMap.getRoom(x, y-1) : null;
			
		case "south":
			return (y < gameMap.getRows() - 1) ? gameMap.getRoom(x, y + 1) : null;
			
		case "east":
			return (x < gameMap.getColumns() - 1) ? gameMap.getRoom(x + 1, y) : null;
			
		case "west":
			return (x > 0) ? gameMap.getRoom(x - 1, y) : null;
			
		default:
			throw new IllegalArgumentException("Invalid direction: " + direction);
		}
	}
}
