package rooms;

public class GameMap {
	private Room[][] map;
	
	public GameMap() {
		initializeMap();
	}
	
	private void initializeMap() {
		map = new Room[3][3];
	
	//Row 1
	map[0][0] = DragonsLair.getInstance();
	
	
	}
}
