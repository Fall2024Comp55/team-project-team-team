import acm.graphics.*;

enum Space {
	PATH(true, "Path.png"),
	GRASS(true, "Grass.png"),
	TALLGRASS(true, "Tall_Grass.png"),
	OBSTACLE(false, "Obstacle.png");
	
	Space(boolean walkable, String tile) {
		this.walkable = walkable;
		this.tile = new GImage(tile);
	}
	
	public boolean walkable;
	private GImage tile;
	
	public void drawSpace(int x, int y) {
		// TODO draw the space on the screen in the right location
	}
	
	public void setPos(int x, int y) {
		tile.setLocation(x, y);
	}
	
	public void move(int dx, int dy) {
		tile.move(dx, dy);
	}
}
