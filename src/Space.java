import acm.graphics.*;

enum Space {
	PATH(true, "Path.png"),
	GRASS(true, "Grass.png"),
	TALLGRASS(true, "Tall_Grass.png"),
	OBSTACLE(false, "Obstacle.png"),
	WATER(true, "water.png"),
	WATER_NONW(true, "water.png"),
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
	
	
	public boolean walkable;
	public String tile;
	
	Space(boolean walkable, String tile) {
		this.walkable = walkable;
		this.tile = tile;
	}
}
