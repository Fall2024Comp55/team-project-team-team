

/* format is name , description , health ,attack , and defense */
/* start with this but can add more */
//edited
//finished but need review:

import acm.graphics.GImage;

public enum SpeciesType {

	SPIDER		("Spider", "A small, agile creature.", 											30, 10, 5,  Type.BUG,    null,			""),
	GLIMMERBUG	("Glimmerbug", "A glowing insect with magical properties.", 					25, 15, 7,  Type.BUG,    Type.FAIRY,	""),
	STONEJAW	("Stonejaw", "A rock-like monster with a strong bite.", 						50, 20, 15, Type.ROCK,   null,			""),
	IRONWHISKER	("Ironwhisker", "A steel Pokémon known for its durability.", 					40, 25, 20, Type.STEEL,  null,			""),
	SHADOWMATH	("Shadowmath", "A mysterious monster that blends into the shadows.", 			35, 18, 12, Type.DARK,   null,			""),
	WATERWISP	("Waterwisp", "A mystical water Pokémon that flows gracefully.", 				28, 12, 8,  Type.WATER,  Type.GHOST,	""),
	FLAMECLAW	("Flameclaw", "A fiery creature with sharp claws and fierce temper.", 			40, 22, 10, Type.FIRE,   Type.FIGHTING,	""),
	FROSTBEAK	("Frostbeak", "An icy bird that can freeze its foes with a glance.", 			32, 18, 15, Type.ICE,    Type.FLYING,	""),
	ROCKSHIELD	("Rockshield", "A stout Pokémon that defends its allies with a sturdy shell.", 	55, 15, 25, Type.ROCK,   null,			""),
	GHOSTFLARE	("Ghostflare", "An ethereal being that flickers in and out of existence.", 		30, 20, 10, Type.GHOST,  null,			""),
	STORMWIND	("Stormwind", "A powerful creature that harnesses the energy of storms.", 		45, 30, 12, Type.FLYING, Type.ELECTRIC,	""),
	THORNTAIL	("Thorntail", "A reptilian Pokémon covered in sharp thorns.", 					38, 17, 18, Type.GROUND, Type.GRASS,	""),
	VENOMSPIT	("Venomspit", "A toxic Pokémon that can paralyze its enemies.", 				26, 25, 5,  Type.POISON, null,			"");


	public String name;
	public String description;
	public GImage sprite;
	
	public int baseHP;
	public int baseATK;
	public int baseDEF;
	
	public Type type1;
	public Type type2;
	
	
	
	SpeciesType(String name, String description, int baseHP, int baseATK, int baseDEF, Type type1, Type type2, String image) {
		this.name = name;
		this.description = description;

		this.sprite = new GImage(image);
		
		this.baseHP = baseHP;
		this.baseATK = baseATK;
		this.baseDEF = baseDEF;
		this.type1 = type1;
		this.type2 = type2;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getHealth() {
		return baseHP;
	}
	public int getAttack() {
		return baseATK;
	}
	public int getDefense() {
		return baseDEF;
	}
	public Type getType1() {
		return type1;
	}
	public Type getType2() {
		return type2;
	}
	@Override
	public String toString() {
		return String.format("%s: %s (HP: %d, Attack: %d, Defense: %d)", name, description, baseHP, baseATK, baseDEF,type1,type2);
	}
}



