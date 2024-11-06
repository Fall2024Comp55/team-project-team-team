enum Move {
    TACKLE			("Tackle", Type.NORMAL, 40, 100),
    BODYSLAM		("Body Slam", Type.NORMAL , 80, 95),
    EMBER           ("Ember", Type.FIRE, 40, 100),
    FLAMETHROWER	("Flamethrower", Type.FIRE , 90, 100),
    FIREBLAST		("Fire Blast", Type.FIRE , 110, 80),
    WATERGUN		("Water Gun", Type.WATER , 40, 100),
    SURF			("Surf", Type.WATER, 90, 100),
    HYDROPUMP		("Hydro Pump", Type.WATER, 110, 80),
    THUNDERBOLT		("Thunderbolt", Type.ELECTRIC, 90, 100),
    EARTHQUAKE		("Earthquake", Type.GROUND, 100, 100);
	
    public String name;
    public Type type;
    public int power;
    public int accuracy;
    
	Move(String name, Type type, int power, int accuracy) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
    }

    public void animate() {
        System.out.println(name + " is being used!");
        // Additional animation logic can be added here
    }
}