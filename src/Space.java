class Space {
	public Tile tile;
	public MapName destination = null;
	public int spawn;
	public Trainers enemy = null;
	public Trainers sightline = null;
	public boolean walkable;
	
	Space(Tile tile) {
		this.tile = tile;
		this.walkable = tile.walkable;
	}
	
	public void setDestination(MapName destination, int spawn) {
		this.destination = destination;
		this.spawn = spawn;
	}
}
