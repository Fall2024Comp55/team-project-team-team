import java.util.ArrayList;
import acm.graphics.GImage;

public enum Maps {
	MAP1(new char[][] {
		{'o','o','o','o','p','o','o','o','o'},
		{'o','g','g','g','p','g','g','g','o'},
		{'o','g','g','g','p','g','g','g','o'},
		{'o','g','g','g','p','g','g','g','o'},
		{'o','g','g','g','p','g','g','g','o'},
		{'o','g','g','g','p','g','g','g','o'},
		{'o','g','g','g','p','g','g','g','o'},
		{'o','g','g','g','p','g','g','g','o'},
		{'o','o','o','o','p','o','o','o','o'}
	}, 4, 8);
	
	Maps(char[][] spaces, int x, int y) {
		this.spaceMap = new Space[spaces.length][spaces[0].length];
		int nextX = 0, nextY = 0;
		for(char[] c : spaces) {
			for(char tile : c) {
				switch(tile) {
				case 'o': this.spaceMap[nextY][nextX] = Space.OBSTACLE; break;
				case 'g': this.spaceMap[nextY][nextX] = Space.GRASS; break;
				case 'p': this.spaceMap[nextY][nextX] = Space.PATH; break;
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
