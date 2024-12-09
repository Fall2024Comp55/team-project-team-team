

/* format is name , description , health ,attack , and defense */
/* start with this but can add more */
//edited
//finished but need review:

import acm.graphics.GImage;

public enum SpeciesType {
	
	SPIDER		("Spider", "A small, agile creature.", 											30, 10, 5,  Type.BUG,    null,			"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.EMBER, Move.EMBER, Move.THUNDERBOLT
	}),
	GLIMMERBUG	("Glimmerbug", "A glowing insect with magical properties.", 					25, 15, 7,  Type.BUG,    Type.FAIRY,	"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.EMBER, Move.THUNDERBOLT, Move.EARTHQUAKE
	}),
	STONEJAW	("Stonejaw", "A rock-like monster with a strong bite.", 						50, 20, 15, Type.ROCK,   null,			"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.EMBER, Move.THUNDERBOLT, Move.EARTHQUAKE
	}),
	IRONWHISKER	("Ironwhisker", "A steel Pokémon known for its durability.", 					40, 25, 20, Type.STEEL,  null,			"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.EMBER, Move.THUNDERBOLT, Move.EARTHQUAKE
	}),
	SHADOWMATH	("Shadowmath", "A mysterious monster that blends into the shadows.", 			100, 18, 12, Type.DARK,   null,			"octoMonsterEv1Front.png", "octoMonsterEv1Back.png", new Move[] {
			Move.TACKLE, Move.EMBER, Move.THUNDERBOLT, Move.EARTHQUAKE
	}),
	WATERWISP	("Waterwisp", "A mystical water Pokémon that flows gracefully.", 				28, 12, 8,  Type.WATER,  Type.GHOST,	"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.WATERGUN, Move.THUNDERBOLT, Move.EARTHQUAKE
	}),
	FLAMECLAW	("Flameclaw", "A fiery creature with sharp claws and fierce temper.", 			40, 22, 10, Type.FIRE,   Type.FIGHTING,	"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.FLAMETHROWER, Move.THUNDERBOLT, Move.EARTHQUAKE
	}),
	FROSTBEAK	("Frostbeak", "An icy bird that can freeze its foes with a glance.", 			32, 18, 15, Type.ICE,    Type.FLYING,	"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.WATERGUN, Move.EMBER, Move.THUNDERBOLT
	}),
	ROCKSHIELD	("Rockshield", "A stout Pokémon that defends its allies with a sturdy shell.", 	55, 15, 25, Type.ROCK,   null,			"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.WATERGUN, Move.EMBER, Move.THUNDERBOLT
	}),
	GHOSTFLARE	("Ghostflare", "An ethereal being that flickers in and out of existence.", 		30, 20, 10, Type.GHOST,  null,			"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.WATERGUN, Move.EMBER, Move.THUNDERBOLT
	}),
	STORMWIND	("Stormwind", "A powerful creature that harnesses the energy of storms.", 		45, 30, 12, Type.FLYING, Type.ELECTRIC,	"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.WATERGUN, Move.EMBER, Move.EARTHQUAKE
	}),
	GREENHORN	("Greenhorn", "A powerful creature that harnesses the energy of storms.", 		50, 15, 25, Type.GRASS,  null,	        "placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.WATERGUN, Move.EMBER, Move.EARTHQUAKE
	}),
	THORNTAIL	("Thorntail", "A reptilian Pokémon covered in sharp thorns.", 					38, 17, 18, Type.GROUND, Type.GRASS,	"placeholderCharacter.png", "", new Move[] {
			Move.TACKLE, Move.WATERGUN, Move.EMBER, Move.EARTHQUAKE
	}),
	VENOMSPIT	("Venomspit", "A toxic Pokémon that can paralyze its enemies.", 				26, 25, 5,  Type.POISON, null,			"excitedGibliEv1Front.png", "excitedGibliEv1Back.png", new Move[] {
			Move.TACKLE, Move.WATERGUN, Move.EMBER, Move.EARTHQUAKE
	});
	
	
	public String name;
	public String description;
	public GImage frontSprite;
	public GImage backSprite;
	
	public int baseHP;
	public int baseATK;
	public int baseDEF;
	
	public Type type1;
	public Type type2;
	
	public Move[] moves;
	
	
	SpeciesType(String name, String description, int baseHP, int baseATK, int baseDEF, Type type1, Type type2, String front, String back, Move[] moves) {
		this.name = name;
		this.description = description;

		this.frontSprite = new GImage(front);
		this.backSprite = new GImage(back);
		
		this.baseHP = baseHP;
		this.baseATK = baseATK;
		this.baseDEF = baseDEF;
		
		this.type1 = type1;
		this.type2 = type2;
		
		this.moves = moves;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s: %s (HP: %d, Attack: %d, Defense: %d)", name, description, baseHP, baseATK, baseDEF,type1,type2);
	}
}



