
public enum Maps {
	MAP1(new Space[][] {
		{Space.OBSTACLE,Space.OBSTACLE,Space.OBSTACLE,Space.PATH,Space.OBSTACLE,Space.OBSTACLE,Space.OBSTACLE},
		{Space.OBSTACLE,Space.GRASS,Space.GRASS,Space.PATH,Space.GRASS,Space.GRASS,Space.OBSTACLE},
		{Space.OBSTACLE,Space.GRASS,Space.GRASS,Space.PATH,Space.GRASS,Space.GRASS,Space.OBSTACLE},
		{Space.OBSTACLE,Space.GRASS,Space.GRASS,Space.PATH,Space.GRASS,Space.GRASS,Space.OBSTACLE},
		{Space.OBSTACLE,Space.GRASS,Space.GRASS,Space.PATH,Space.GRASS,Space.GRASS,Space.OBSTACLE},
		{Space.OBSTACLE,Space.GRASS,Space.GRASS,Space.PATH,Space.GRASS,Space.GRASS,Space.OBSTACLE},
		{Space.OBSTACLE,Space.GRASS,Space.GRASS,Space.PATH,Space.GRASS,Space.GRASS,Space.OBSTACLE},
		{Space.OBSTACLE,Space.GRASS,Space.GRASS,Space.PATH,Space.GRASS,Space.GRASS,Space.OBSTACLE},
		{Space.OBSTACLE,Space.OBSTACLE,Space.OBSTACLE,Space.PATH,Space.OBSTACLE,Space.OBSTACLE,Space.OBSTACLE}
	}, 3, 8);
	
	Maps(Space[][] spaceMap, int x, int y) {
		this.spaceMap = spaceMap;
		this.startX = x;
		this.startY = y;
	}
	
	public Space[][] spaceMap;
	public int startX;
	public int startY;
}
