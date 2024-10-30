
public enum enumType {
    FIRE, WATER, GRASS;
	public String toString() {
		switch(this) {
			case FIRE: return "FIRE";
			case WATER: return "WATER";
			case GRASS: return "GRASS";
		}
		return "n/a";
	}
}
