import acm.graphics.*;

enum Space {
	PATH(true, "Path.png"),
	GRASS(true, "Grass.png"),
	TALLGRASS(true, "Tall_Grass.png"),
	OBSTACLE(false, "Obstacle.png");
	
	public boolean walkable;
	public String tile;
	
	Space(boolean walkable, String tile) {
		this.walkable = walkable;
		this.tile = tile;
	}
}
