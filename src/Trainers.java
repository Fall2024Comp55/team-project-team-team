
public enum Trainers {
	ROUTE1TRAINER0("Jaques", Direction.RIGHT, false, 450, new Monster[] {
			new Monster(SpeciesType.SPIDER, 5)
	});
	
	public String name;
	public Direction facing;
	public boolean defeated;
	public Monster[] team;
	public int money;
	
	Trainers(String name, Direction facing, boolean defeated, int money, Monster[] team) {
		this.name = name;
		this.team = team;
		this.facing = facing;
		this.defeated = defeated;
		this.money = money;
	}
}
