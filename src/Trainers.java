
public enum Trainers {
	ROUTE1TRAINER0("Jaques", Direction.RIGHT, false, new Monster[] {
			new Monster(SpeciesType.SPIDER, 5)
	});
	
	public String name;
	public Direction facing;
	public boolean defeated;
	public Monster[] team;
	
	Trainers(String name, Direction facing, boolean defeated, Monster[] team) {
		this.name = name;
		this.team = team;
		this.facing = facing;
		this.defeated = defeated;
	}
}
