
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
	});
	
	Maps(Space[][] spaceMap) {
		this.spaceMap = spaceMap;
	}
	
	public Space[][] spaceMap;
}
