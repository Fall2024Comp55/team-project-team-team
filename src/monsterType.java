
public enum monsterType {
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
		}
		return "n/a";
	}
}
