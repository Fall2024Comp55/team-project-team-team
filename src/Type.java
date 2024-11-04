import java.util.ArrayList;

enum TypeName {
	NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, STEEL, FAIRY;
	
	public String toString() {
		switch(this) {
			case NORMAL: return "NORMAL";
			case FIRE: return "FIRE";
			case WATER: return "WATER";
			case GRASS: return "GRASS";
			case ELECTRIC: return "ELECTRIC";
			case ICE: return "ICE";
			case FIGHTING: return "FIGHTING";
			case POISON: return "POISON";
			case GROUND: return "GROUND";
			case FLYING: return "FLYING";
			case PSYCHIC: return "PSYCHIC";
			case BUG: return "BUG";
			case ROCK: return "ROCK";
			case GHOST: return "GHOST";
			case DRAGON: return "DRAGON";
			case DARK: return "DARK";
			case STEEL: return "STEEL";
			case FAIRY: return "FAIRY";
			default: return "n/a";
		}
	}
}

enum Type {
	NORMAL(TypeName.NORMAL,		new TypeName[]{}, 
						    	new TypeName[]{TypeName.ROCK, TypeName.STEEL}, 
						    	new TypeName[]{TypeName.GHOST}),
	
	FIRE(TypeName.FIRE,     	new TypeName[]{TypeName.GRASS, TypeName.ICE, TypeName.BUG, TypeName.STEEL}, 
						    	new TypeName[]{TypeName.FIRE, TypeName.WATER, TypeName.ROCK, TypeName.DRAGON}, 
						    	new TypeName[]{}),
	
	WATER(TypeName.WATER,     	new TypeName[]{TypeName.FIRE, TypeName.GROUND, TypeName.ROCK}, 
		    					new TypeName[]{TypeName.WATER, TypeName.GRASS, TypeName.DRAGON}, 
		    					new TypeName[]{}),
	
	ELECTRIC(TypeName.ELECTRIC,	new TypeName[]{TypeName.WATER, TypeName.FLYING}, 
								new TypeName[]{TypeName.ELECTRIC, TypeName.GRASS, TypeName.DRAGON}, 
								new TypeName[]{TypeName.GROUND}),
	
	GRASS(TypeName.GRASS,		new TypeName[]{TypeName.WATER, TypeName.GROUND, TypeName.ROCK}, 
								new TypeName[]{TypeName.FIRE, TypeName.GRASS, TypeName.POISON, TypeName.FLYING, TypeName.BUG, TypeName.DRAGON, TypeName.STEEL}, 
								new TypeName[]{}),
	
	ICE(TypeName.ICE,     		new TypeName[]{TypeName.GRASS, TypeName.GROUND, TypeName.FLYING, TypeName.DRAGON}, 
								new TypeName[]{TypeName.FIRE, TypeName.WATER, TypeName.ICE, TypeName.STEEL}, 
								new TypeName[]{}),
	
	FIGHTING(TypeName.FIGHTING,	new TypeName[]{TypeName.NORMAL, TypeName.ICE, TypeName.ROCK, TypeName.DARK, TypeName.STEEL}, 
								new TypeName[]{TypeName.POISON, TypeName.FLYING, TypeName.PSYCHIC, TypeName.BUG, TypeName.FAIRY}, 
								new TypeName[]{TypeName.GHOST}),
	
	POISON(TypeName.POISON,     new TypeName[]{TypeName.GRASS, TypeName.FAIRY}, 
								new TypeName[]{TypeName.POISON, TypeName.GROUND, TypeName.ROCK, TypeName.GHOST}, 
								new TypeName[]{TypeName.STEEL}),
	
	GROUND(TypeName.GROUND,     new TypeName[]{TypeName.FIRE, TypeName.ELECTRIC, TypeName.POISON, TypeName.ROCK, TypeName.STEEL}, 
								new TypeName[]{TypeName.GRASS, TypeName.BUG}, 
								new TypeName[]{TypeName.FLYING}),
	
	FLYING(TypeName.FLYING,     new TypeName[]{TypeName.GRASS, TypeName.FIGHTING, TypeName.BUG}, 
								new TypeName[]{TypeName.ELECTRIC, TypeName.ROCK, TypeName.STEEL}, 
								new TypeName[]{}),
	
	PSYCHIC(TypeName.PSYCHIC,	new TypeName[]{TypeName.FIGHTING, TypeName.POISON}, 
								new TypeName[]{TypeName.PSYCHIC, TypeName.STEEL}, 
								new TypeName[]{TypeName.DARK}),
	
	BUG(TypeName.BUG,     		new TypeName[]{TypeName.GRASS, TypeName.PSYCHIC, TypeName.DARK}, 
								new TypeName[]{TypeName.FIRE, TypeName.FIGHTING, TypeName.POISON, TypeName.FLYING, TypeName.GHOST, TypeName.STEEL, TypeName.FAIRY}, 
								new TypeName[]{}),
	
	ROCK(TypeName.ROCK,     	new TypeName[]{TypeName.FIRE, TypeName.ICE, TypeName.FLYING, TypeName.BUG}, 
								new TypeName[]{TypeName.FIGHTING, TypeName.GROUND, TypeName.STEEL}, 
								new TypeName[]{}),
	
	GHOST(TypeName.GHOST,     	new TypeName[]{TypeName.PSYCHIC, TypeName.GHOST}, 
								new TypeName[]{TypeName.DARK}, 
								new TypeName[]{TypeName.NORMAL}),
	
	DRAGON(TypeName.DRAGON,     new TypeName[]{TypeName.DRAGON}, 
								new TypeName[]{TypeName.STEEL}, 
								new TypeName[]{TypeName.FAIRY}),
	
	DARK(TypeName.DARK,     	new TypeName[]{TypeName.PSYCHIC, TypeName.GHOST}, 
								new TypeName[]{TypeName.FIGHTING, TypeName.DARK, TypeName.FAIRY}, 
								new TypeName[]{}),
	
	STEEL(TypeName.STEEL,     	new TypeName[]{TypeName.ICE, TypeName.ROCK, TypeName.FAIRY}, 
								new TypeName[]{TypeName.FIRE, TypeName.WATER, TypeName.ELECTRIC, TypeName.STEEL}, 
								new TypeName[]{}),
	
	FAIRY(TypeName.FAIRY,     	new TypeName[]{TypeName.FIGHTING, TypeName.DRAGON, TypeName.DARK}, 
								new TypeName[]{TypeName.FIRE, TypeName.POISON, TypeName.STEEL}, 
								new TypeName[]{});
	
	public TypeName type;
	public TypeName[] superEffective;
	public TypeName[] notEffective;
	public TypeName[] immune;
	
	Type(TypeName type, TypeName[] superEffective, TypeName[] notEffective, TypeName[] immune) {
		this.type = type;
		this.superEffective = superEffective;
		this.notEffective = notEffective;
		this.immune = immune;
	}
}