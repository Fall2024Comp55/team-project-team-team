
public enum ItemName {
	POTION("Restores 25% Hp", "Heal", 1), 
	BIGPOTION("Restores 50% Hp", "Heal", 2), 
	SUPERPOTION("Restores 75% Hp", "Heal", 3), 
	MAXPOTION("Restores 100% Hp", "Heal", 4), 
	BASICBALL("25% successful catch rate", "Ball", 1), 
	SUPERBALL("50% successful catch rate", "Ball", 2), 
	ULTRABALL("75% successful catch rate", "Ball", 3), 
	MASTERBALL("100% successful catch rate", "Ball", 4),
	BADGE("Proof of a Trainer's victory in a battle against the Gym Leader", "Badge", 0);
	
	private final String description;
	private final String bagTab;
	private final int type;
	
	ItemName(String description, String bagTab, int type) {
		this.description = description;
		this.bagTab = bagTab;
		this.type = type;
	}
	public String bagTab() {
		switch(this) {
			case POTION: return "POTION";
			case BIGPOTION: return "BIGPOTION";
			case SUPERPOTION: return "SUPERPOTION";
			case MAXPOTION: return "MAXPOTION";
			case BASICBALL: return "BASICBALL";
			case SUPERBALL: return "SUPERBALL";
			case MASTERBALL: return "MASTERBALL";
			case BADGE: return "BADGE";
			default: return "n/a";
		}
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getBagTab() {
		return bagTab;
	}
	
	public int getType() {
		return type;
	}
	
}
