class Space {
	public Tile tile;
	public MapName destination = null;
	public int spawn;
	
	Space(Tile tile) {
		this.tile = tile;
	}
	
	public void setDestination(MapName destination, int spawn) {
		this.destination = destination;
		this.spawn = spawn;
	}
}
