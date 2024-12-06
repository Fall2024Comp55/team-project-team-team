
public enum Trainers {
	ROUTE1TRAINER0("Jaques", Direction.RIGHT, false, 450, new SpeciesType[] {
			SpeciesType.SPIDER
		}, new int[] { 5 });
	
	public String name;
	public Direction facing;
	public boolean defeated;
	public SpeciesType[] team;
	public int[] levels;
	public int money;
	
	Trainers(String name, Direction facing, boolean defeated, int money, SpeciesType[] team, int[] levels) {
		this.name = name;
		this.team = team;
		this.levels = levels;
		this.facing = facing;
		this.defeated = defeated;
		this.money = money;
	}
}
