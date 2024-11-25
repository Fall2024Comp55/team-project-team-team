public enum Tile {
	PATH(true, "Path.png"),
	GRASS(true, "Grass.png"),
	TALLGRASS(true, "Tall_Grass.png"),
	OBSTACLE(false, "Obstacle.png"),
	WATER(false, "water.png"),
	WATER_NONW(false, "water.png"),
	STARTERHOUSE(true, "housePOkemonGame2"),
	POKECENTER(true, "pokecenterDone"),
	TREE(false, "Tree.png"),
	HOME1(false, "House1.png"),
	HOME2(false, "House2.png"),
	HOME3(false, "House3.png"),
	HOME4(false, "House4.png"),
	HOME5(false, "House5.png"),
	HOME6(false, "House6.png"),
	HOME7(false, "House7.png");
	
	public String image;
	public boolean walkable;
	
	Tile(boolean walkable, String image) {
		this.walkable = walkable;
		this.image = image;
	}
}
