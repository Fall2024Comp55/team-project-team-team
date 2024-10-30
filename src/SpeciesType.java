/**
 * 
 * @author Osvaldo
 *
 */
public enum SpeciesType{
	MYCAR, TRUCK, AUTO;
	
	public String toString() {
		switch(this) {
			case MYCAR: return "car";
			case TRUCK: return "truck";
			case AUTO: return "auto";
		}
		return "n/a";
	}
	
}
