import java.util.ArrayList;
import acm.graphics.GImage;

public enum Maps {
	MAP1(new char[][] {
		{'o','o','o','o','p','o','o','o','o','o','o','o','o','o','o','o'},
		{'o','G','G','g','p','g','g','g','g','g','g','g','g','g','g','o'},
		{'o','G','G','g','p','g','g','g','g','g','g','g','g','g','g','o'},
		{'o','G','G','g','p','g','t','g','g','g','g','g','g','g','g','o'},
		{'o','g','g','g','p','g','g','1','2','3','4','5','6','7','g','o'},
		{'o','g','g','g','p','g','p','p','p','p','p','p','g','g','g','o'},
		{'o','w','w','g','p','g','g','g','g','g','g','g','g','g','g','o'},
		{'o','w','w','w','p','g','G','G','g','g','g','g','g','g','g','o'},
		{'o','o','o','o','p','o','o','o','o','o','o','o','o','o','o','o'}
	}, 4, 8);
	
	Maps(char[][] spaces, int x, int y) {
		this.spaceMap = new Space[spaces.length][spaces[0].length];
		int nextX = 0, nextY = 0;
		for(char[] c : spaces) {
			for(char tile : c) {
				switch(tile) {
				case 'o': this.spaceMap[nextY][nextX] = Space.OBSTACLE; break;
				case 'g': this.spaceMap[nextY][nextX] = Space.GRASS; break;
				case 'G': this.spaceMap[nextY][nextX] = Space.TALLGRASS; break;
				case 'p': this.spaceMap[nextY][nextX] = Space.PATH; break;
				case 'w': this.spaceMap[nextY][nextX] = Space.WATER; break;
				case 't': this.spaceMap[nextY][nextX] = Space.TREE; break;
				case '1': this.spaceMap[nextY][nextX] = Space.HOME1; break;
				case '2': this.spaceMap[nextY][nextX] = Space.HOME2; break;
				case '3': this.spaceMap[nextY][nextX] = Space.HOME3; break;
				case '4': this.spaceMap[nextY][nextX] = Space.HOME4; break;
				case '5': this.spaceMap[nextY][nextX] = Space.HOME5; break;
				case '6': this.spaceMap[nextY][nextX] = Space.HOME6; break;
				case '7': this.spaceMap[nextY][nextX] = Space.HOME7; break;
				}
				nextX += 1;
			}
			nextY += 1;
			nextX = 0;
		}
		startX = x;
		startY = y;
	}
	
	public Space[][] spaceMap;
	public int startX;
	public int startY;
}
