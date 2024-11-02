public enum Moves {
    TACKLE("Tackle", 40, 100),
    FLAMETHROWER("Flamethrower", 90, 100),
    WATERGUN("Water Gun", 40, 100),
    THUNDERBOLT("Thunderbolt", 90, 100),
    EARTHQUAKE("Earthquake", 100, 100);

    private final String moveName;
    private final int power;
    private final int accuracy;

	Moves(String moveName, int power, int accuracy) {
        this.moveName = moveName;
        this.power = power;
        this.accuracy = accuracy;
    }

    public String getMoveName() {
        return moveName;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }


    public void animateMove() {
        System.out.println(moveName + " is being used!");
        // Additional animation logic can be added here
    }
}