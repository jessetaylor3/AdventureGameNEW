package rooms;

public class GameMap {
	private Room[][] map;
	
	public GameMap() {
		initializeMap();
	}
	
	private void initializeMap() {
		map = new Room[3][3];
	
		//Row 1
		map[0][0] = DragonsLair.getInstance(this);
		map[0][1] = DungeonRoom.getInstance(this);
		map[0][2] = ArmorRoom.getInstance(this);
		
		//Row 2
		map[1][0] = MountainRange.getInstance(this);
		map[1][1] = House.getInstance(this);
		map[1][2] = Backyard.getInstance(this);
		
		//Row 3
		map[2][0] = CrystalClearing.getInstance(this);
		map[2][1] = DenseForest.getInstance(this);
		map[2][2] = GoblinsNook.getInstance(this);
	}
		
	public Room getRoom(int x, int y) {
		return map[x][y];
	}
	
	public int getRows() {
		return map.length;
	}
	
	public int getColumns() {
		return (map.length > 0) ? map[0].length : 0;
	}
}

/*	Map Layout
 * | Dragon's Lair   | Dungeon Room | Armor Room
 * | Mountain Range  | 	  House	    | Backyard	
 * | Crystal Clearing| Dense Forest | Goblin's Nook
 * */
