import java.util.ArrayList;
import acm.graphics.GImage;

// comment
enum MapName {
	HOMETOWN, ROUTE1, GYM;
}

public enum Maps {
	HOMETOWN(new char[][] {
		{'w','w','w','o','p','o','o','o','o','o','o','o','o','o','o','o'},
		{'w','w','w','g','p','g','g','g','g','g','g','g','g','g','g','o'},
		{'w','w','g','g','p','g','g','g','g','g','g','g','g','g','g','o'},
		{'o','g','g','g','p','g','t','g','g','g','g','g','g','g','g','o'},
		{'o','g','g','g','p','g','g','1','2','3','4','5','6','7','g','o'},
		{'o','g','g','g','p','g','p','p','p','p','p','p','g','g','g','o'},
		{'o','G','G','g','p','g','g','g','g','g','g','g','g','g','g','o'},
		{'o','G','G','G','p','g','G','G','g','g','g','g','g','g','g','o'},
		{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'}
	}, new int[][] { // Array containing all possible starting coordinates on the map
		{8, 5}, {4, 0}
	}),
	
	ROUTE1(new char[][] { // Array of characters corresponding to tile types
		{'o','o','o','o','o','o','o','o','o','o','p','o','o','o','o','o','o','o','o','o'},
		{'o','t','G','g','G','G','G','G','G','g','p','g','G','G','G','G','G','G','G','o'},
		{'o','t','G','g','G','G','G','G','g','g','p','g','g','g','g','G','G','G','G','o'},
		{'o','t','G','g','G','G','G','G','g','g','p','g','g','g','g','g','g','G','G','o'},
		{'o','t','g','g','G','G','G','g','g','g','p','g','g','g','g','g','g','g','G','o'},
		{'o','t','g','g','G','G','G','g','g','g','p','g','g','g','g','g','g','g','g','o'},
		{'o','t','g','g','G','G','g','g','g','g','p','p','p','p','p','p','g','g','g','o'},
		{'o','t','t','g','G','G','g','g','g','g','g','g','g','g','g','p','g','g','G','o'},
		{'o','t','t','t','t','G','G','g','g','g','g','g','g','g','g','g','g','G','G','o'},
		{'o','t','t','t','t','t','t','t','t','g','g','g','g','g','G','G','G','G','G','o'},
		{'o','t','t','t','t','t','t','t','t','t','t','t','G','G','G','G','G','G','G','o'},
		{'o','t','t','t','G','G','G','G','g','g','g','G','G','G','G','G','G','G','G','o'},
		{'o','t','G','G','G','g','g','g','g','g','g','g','g','g','g','G','G','G','G','o'},
		{'o','G','G','g','g','g','g','g','g','g','g','g','g','g','g','g','G','G','G','o'},
		{'w','G','g','g','p','p','p','p','p','p','p','p','p','g','g','g','G','G','G','o'},
		{'w','w','g','g','p','g','g','g','g','g','g','g','g','g','G','G','G','G','G','o'},
		{'w','w','g','g','p','g','g','g','g','g','g','g','G','G','G','G','G','G','t','o'},
		{'w','w','w','g','p','g','g','g','g','G','G','G','G','G','G','G','G','t','t','o'},
		{'w','w','w','g','p','g','g','g','G','G','G','G','t','t','t','t','t','t','t','o'},
		{'w','w','w','o','p','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'}
	}, new int[][] { // Array containing all possible starting coordinates on the map
		{4, 19}, {10, 0}
	}),
	GYM(new char[][] { // Array of characters corresponding to tile types
		{'o','o','o','o','o','o','o','o','o','o','o','o','o','o','o','o'},
		{'o','t','t','t','t','t','t','t','t','t','t','t','t','w','w','o'},
		{'o','t','t','p','p','p','p','p','p','p','p','p','t','w','w','o'},
		{'o','t','t','p','g','g','p','g','p','g','g','p','t','w','w','o'},
		{'o','t','t','p','g','g','p','p','p','g','g','p','t','w','w','o'},
		{'o','t','t','p','g','g','g','g','g','g','g','p','t','w','w','o'},
		{'o','t','t','p','g','g','p','p','p','g','g','p','t','w','w','o'},
		{'o','t','t','p','p','p','p','g','p','p','p','p','t','w','w','o'},
		{'o','t','t','p','g','g','p','p','p','g','g','p','t','w','w','o'},
		{'o','t','t','p','g','g','g','g','g','g','g','p','t','w','w','o'},
		{'o','t','t','p','g','g','p','p','p','g','g','p','t','w','w','o'},
		{'o','t','t','p','g','g','p','g','p','g','g','p','t','w','w','o'},
		{'o','t','t','p','p','p','p','p','p','p','p','p','t','g','g','o'},
		{'o','t','t','g','g','g','g','g','g','g','g','g','g','g','g','o'},
		{'o','o','o','o','o','o','o','p','o','o','o','o','o','o','o','o'}
	}, new int[][] { // Array containing all possible starting coordinates on the map
		{7,14}
	});
	Maps(char[][] spaces, int[][] starts) {
		this.spaceMap = new Space[spaces.length][spaces[0].length];
		int nextX = 0, nextY = 0;
		for(char[] c : spaces) {
			for(char tile : c) {
				switch(tile) {
				case 'o': this.spaceMap[nextY][nextX] = new Space(Tile.OBSTACLE); break;
				case 'g': this.spaceMap[nextY][nextX] = new Space(Tile.GRASS); break;
				case 'G': this.spaceMap[nextY][nextX] = new Space(Tile.TALLGRASS); break;
				case 'p': this.spaceMap[nextY][nextX] = new Space(Tile.PATH); break;
				case 'w': this.spaceMap[nextY][nextX] = new Space(Tile.WATER); break;
				case 't': this.spaceMap[nextY][nextX] = new Space(Tile.TREE); break;
				case '1': this.spaceMap[nextY][nextX] = new Space(Tile.HOME1); break;
				case '2': this.spaceMap[nextY][nextX] = new Space(Tile.HOME2); break;
				case '3': this.spaceMap[nextY][nextX] = new Space(Tile.HOME3); break;
				case '4': this.spaceMap[nextY][nextX] = new Space(Tile.HOME4); break;
				case '5': this.spaceMap[nextY][nextX] = new Space(Tile.HOME5); break;
				case '6': this.spaceMap[nextY][nextX] = new Space(Tile.HOME6); break;
				case '7': this.spaceMap[nextY][nextX] = new Space(Tile.HOME7); break;
				}
				nextX += 1;
			}
			nextY += 1;
			nextX = 0;
		}
		this.starts = starts;
	}
	
	public Space[][] spaceMap;
	public int[][] starts;
	public int startX;
	public int startY;
	
	static {
		HOMETOWN.spaceMap[0][4].setDestination(MapName.ROUTE1, 0);
		
		ROUTE1.spaceMap[19][4].setDestination(MapName.HOMETOWN, 1);
		
		
		ROUTE1.spaceMap[2][8].enemy = Trainers.ROUTE1TRAINER0;
		ROUTE1.spaceMap[2][9].sightline = Trainers.ROUTE1TRAINER0;
		ROUTE1.spaceMap[2][10].sightline = Trainers.ROUTE1TRAINER0;
		ROUTE1.spaceMap[2][11].sightline = Trainers.ROUTE1TRAINER0;
		ROUTE1.spaceMap[2][12].sightline = Trainers.ROUTE1TRAINER0;
		
		ROUTE1.spaceMap[0][10].setDestination(MapName.GYM, 0);
		GYM.spaceMap[14][7].setDestination(MapName.ROUTE1, 1);
		
		GYM.spaceMap[3][7].enemy = Trainers.GYMLEADER;
		GYM.spaceMap[4][7].sightline = Trainers.GYMLEADER;
		GYM.spaceMap[5][7].sightline = Trainers.GYMLEADER;
		
		// GYM.spaceMap[2][9].sightline = Trainers.GYMLEADER;
		// GYM.spaceMap[2][10].sightline = Trainers.GYMLEADER;
		// GYM.spaceMap[2][11].sightline = Trainers.GYMLEADER;
		// GYM.spaceMap[2][12].sightline = Trainers.GYMLEADER;
	}
}


