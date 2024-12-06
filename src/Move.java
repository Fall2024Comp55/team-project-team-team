public enum Move {
    TACKLE			("Tackle", Type.NORMAL, 40, 100),
    BODYSLAM		("Body Slam", Type.NORMAL , 80, 95),
    
    EMBER           ("Ember", Type.FIRE, 40, 100),
    FLAMETHROWER	("Flamethrower", Type.FIRE , 90, 100),
    FIREBLAST		("Fire Blast", Type.FIRE , 110, 80),
    
    WATERGUN		("Water Gun", Type.WATER , 40, 100),
    SURF			("Surf", Type.WATER, 90, 100),
    HYDROPUMP		("Hydro Pump", Type.WATER, 110, 80),
    
    SHOCK           ("Shock", Type.ELECTRIC, 40, 100),
    THUNDERBOLT		("Thunderbolt", Type.ELECTRIC, 90, 100),
    THUNDER         ("Thunder", Type.ELECTRIC, 110, 80),
    
    HEX             ("Hex", Type.GHOST, 40, 100),
    SHADOWBALL		("Shadow Ball", Type.GHOST, 90, 100),
    
    RUMBLE		    ("Rumble", Type.GROUND, 55, 100),
    EARTHQUAKE		("Earthquake", Type.GROUND, 100, 100),
    
    ROCKTHROW		("Rock Throw", Type.ROCK, 55, 90),
    STONEEDGE		("Stone Edge", Type.ROCK, 110, 80);
	
    public String name;
    public Type type;
    public int power;
    public int accuracy;
    
    Move() {
    	this.name = "Tackle";
        this.type = Type.NORMAL;
        this.power = 40;
        this.accuracy = 100;
    }
    
    
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
    
    
    public int calculateDamage(Monster attacker, Monster defender) {
        // Simplified damage calculation using base power, attack, and defense
        int baseDamage = ((2 * attacker.getLevel() / 5 + 2) * power * attacker.getAtk() / defender.getDef()) / 50 + 2;
        return baseDamage;
    }
    
    public String getName() {
    	return name;
    }
}
//done