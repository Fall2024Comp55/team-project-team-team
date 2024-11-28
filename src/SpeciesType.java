

/* format is name , description , health ,attack , and defense */
/* start with this but can add more */
//edited
//finished but need review:
public enum SpeciesType {
	SPIDER("Spider", "A small, agile creature.", 30, 10, 5, Type.BUG, Type.BUG),
	GLIMMERBUG("Glimmerbug", "A glowing insect with magical properties.", 25, 15, 7, Type.BUG, Type.BUG),
	STONEJAW("Stonejaw", "A rock-like monster with a strong bite.", 50, 20, 15, Type.ROCK, Type.ROCK),
	IRONWHISKER("Ironwhisker", "A steel Pokémon known for its durability.", 40, 25, 20, Type.STEEL, Type.STEEL),
	SHADOWMATH("Shadowmath", "A mysterious monster that blends into the shadows.", 35, 18, 12, Type.DARK, Type.DARK),
	WATERWISP("Waterwisp", "A mystical water Pokémon that flows gracefully.", 28, 12, 8, Type.WATER, Type.WATER),
	FLAMECLAW("Flameclaw", "A fiery creature with sharp claws and fierce temper.", 40, 22, 10, Type.FIRE, Type.FIRE),
	FROSTBEAK("Frostbeak", "An icy bird that can freeze its foes with a glance.", 32, 18, 15, Type.ICE, Type.ICE),
	ROCKSHIELD("Rockshield", "A stout Pokémon that defends its allies with a sturdy shell.", 55, 15, 25, Type.ROCK, Type.ROCK),
	GHOSTFLARE("Ghostflare", "An ethereal being that flickers in and out of existence.", 30, 20, 10, Type.GHOST, Type.GHOST),
	STORMWIND("Stormwind", "A powerful creature that harnesses the energy of storms.", 45, 30, 12, Type.FLYING, Type.FLYING),
	THORNTAIL("Thorntail", "A reptilian Pokémon covered in sharp thorns.", 38, 17, 18, Type.GROUND, Type.GROUND),
	VENOMSPIT("Venomspit", "A toxic Pokémon that can paralyze its enemies.", 26, 25, 5, Type.POISON, Type.POISON);
	
	private String name = "";
	private  String description = "";
	private  int health;
	private  int attack;
	private  int defense;
	private  Type type1;
	private  Type type2;
	SpeciesType(String name, String description, int health, int attack, int defense, Type type1, Type type2) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.type1 = type1;
		this.type2 = type2;
		}
	@Override
	public String toString() {
		return String.format("%s: %s (HP: %d, Attack: %d, Defense: %d)", name, description, health, attack, defense, type1, type2);
		}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getHealth() {
		return health;
	}
	public int getAttack() {
		return attack;
	}
	public int getDefense() {
		return defense;
	}
	public Type getType1() {
		return type1;
	}
	public Type getType2() {
		return type2;
	}
}



