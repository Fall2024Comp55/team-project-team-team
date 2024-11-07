
public enum ItemName {
	POTION, BIGPOTION, MAXPOTION, BASICBALL, SUPERBALL, ULTRABALL;
	public String toString() {
		switch(this) {
			case POTION: return "POTION";
			case BIGPOTION: return "BIGPOTION";
			case MAXPOTION: return "MAXPOTION";
			case BASICBALL: return "BASICBALL";
			case SUPERBALL: return "SUPERBALL";
			default: return "n/a";
		}
	}
}
