
/* format is name , description , health ,attack , and defense */
/* start with this but can add more */
public enum SpeciesType {
    SPIDER("Spider", "A small, agile creature.", 30, 10, 5),
    GLIMMERBUG("Glimmerbug", "A glowing insect with magical properties.", 25, 15, 7),
    STONEJAW("Stonejaw", "A rock-like monster with a strong bite.", 50, 20, 15),
    IRONWHISKER("Ironwhisker", "A steel Pokémon known for its durability.", 40, 25, 20),
    SHADOWMATH("Shadowmath", "A mysterious monster that blends into the shadows.", 35, 18, 12),
    WATERWISP("Waterwisp", "A mystical water Pokémon that flows gracefully.", 28, 12, 8),
    FLAMECLAW("Flameclaw", "A fiery creature with sharp claws and fierce temper.", 40, 22, 10),
    FROSTBEAK("Frostbeak", "An icy bird that can freeze its foes with a glance.", 32, 18, 15),
    ROCKSHIELD("Rockshield", "A stout Pokémon that defends its allies with a sturdy shell.", 55, 15, 25),
    GHOSTFLARE("Ghostflare", "An ethereal being that flickers in and out of existence.", 30, 20, 10),
    STORMWIND("Stormwind", "A powerful creature that harnesses the energy of storms.", 45, 30, 12),
    THORNTAIL("Thorntail", "A reptilian Pokémon covered in sharp thorns.", 38, 17, 18),
    VENOMSPIT("Venomspit", "A toxic Pokémon that can paralyze its enemies.", 26, 25, 5);

    private final String name;
    private final String description;
    private final int health;
    private final int attack;
    private final int defense;

    SpeciesType(String name, String description, int health, int attack, int defense) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (HP: %d, Attack: %d, Defense: %d)", name, description, health, attack, defense);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
}