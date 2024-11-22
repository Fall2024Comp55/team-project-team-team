
enum BadgeType {
	NORMAL_BADGE, FIRE_BADGE, WATER_BADGE, GRASS_BADGE, ELECTRIC_BADGE, ICE_BADGE, FIGHTING_BADGE, POISON_BADGE, GROUND_BADGE, FLYING_BADGE, 
	PSYCHIC_BADGE, BUG_BADGE, ROCK_BADGE, GHOST_BADGE, DRAGON_BADGE, DARK_BADGE, STEEL_BADGE, FAIRY_BADGE;
	
	public String toString() {
		switch(this) {
			case NORMAL_BADGE: return "Normal Badge";
			case FIRE_BADGE: return "Fire Badge";
			case WATER_BADGE: return "Water Badge";
			case GRASS_BADGE: return "Grass Badge";
			case ELECTRIC_BADGE: return "Electric Badge";
			case ICE_BADGE: return "Ice Badge";
			case FIGHTING_BADGE: return "Fighting Badge";
			case POISON_BADGE: return "Poison Badge";
			case GROUND_BADGE: return "Ground Badge";
			case FLYING_BADGE: return "Flying Badge";
			case PSYCHIC_BADGE: return "Psychic Badge";
			case BUG_BADGE: return "Bug Badge";
			case ROCK_BADGE: return "Rock Badge";
			case GHOST_BADGE: return "Ghost Badge";
			case DRAGON_BADGE: return "Dragon Badge";
			case DARK_BADGE: return "Dark Badge";
			case STEEL_BADGE: return "Steel Badge";
			case FAIRY_BADGE: return "Fairy Badge";
			default: return "n/a";
		}
	}
}
