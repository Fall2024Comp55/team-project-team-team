
import java.util.List;
import java.util.ArrayList;
import acm.graphics.*;
import java.util.Random;
//finshed but need review:
public class Monster {
	
	private SpeciesType species;
    private GImage sprite;
    private String description;
    private int experience = 0 ;
    private int level;
    private int atk;
    private int def;
    private int spatk;
    private int spdef;
    private int health;
    private int maxHealth;
    private Type type1;
    private Type type2;
    String name = "";
    private List<Move> moves;
    
    public Monster(String name, String description , int hp, int attack, int defense,  Type type1, Type type2, int maxhealth, int level) {
        this.name = name;
        this.description = description;
        this.health = hp;
        this.maxHealth = maxhealth;
        this.atk = attack;
        this.def = defense;
        this.type1 = type1;
        this.type2 = type2;
        this.level = level;

        moves = new ArrayList<Move>();
    }
    
    Monster(SpeciesType specType, int level) {
    	this.name = specType.getName();
    	this.species = specType;
    	this.experience = 0;
    	this.level = 1;
    	this.atk = specType.getAttack();
    	this.def = specType.getDefense();
    	this.health = specType.getHealth();
    	this.type1 = specType.getType1();
    	this.type2 = specType.getType2();
    	this.level = level;
    	moves = new ArrayList<Move>();
    }
    
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isFainted() {
        return health <= 0;
    }
    public int getAttack() {
        return atk;
    }

    public int getDefense() {
        return def;
    }

    public int getlevel() {
        return level;
    }
    
    public String getName() {
        
		return name;
    }
    
    public List<Move> getMoves1() {
        return moves;
    }
    

    public boolean updateHP(int hpChange) {
    	this.health = this.health + hpChange;
        return true;
    }

    public void gainXP(int xp) {
       this.experience = this.experience +  xp;
    }

    public void changeMove(int index, Move newMove) {
    	  this.moves.set(index, newMove);
    }

    public void levelUp() {
        if(experience == 300 && level == 5 ) {
        	level++;
        	experience = 0;
        }else if(experience == 400 && level == 6 ) {
        	level++;
        	experience = 0;
        }
        else if (experience == 500 && level == 6 ) {
        	level++;
        	experience = 0;
        }else if (experience == 600 && level == 8 ) {
        	level++;
        	experience = 0;
        }
        else if (experience == 700 && level == 9 ) {
        	level++;
        	experience = 0;
        }
        else if (experience == 800 && level == 10 ) {
        	level++;
        	experience = 0;
        }
        else if (experience == 900 && level == 11 ) {
        	level++;
        	experience = 0;
        }
        else if (experience == 1000 && level == 12 ) {
        	level++;
        	experience = 0;
        }else if (experience == 1000 && level == 13 ) {
        	level++;
        	experience = 0;
        }else if (experience == 1000 && level == 14 ) {
        	level++;
        	experience = 0;
        }else if (experience == 1000 && level == 15 ) {
        	level++;
        	experience = 0;
        }else if (experience == 1000 && level == 16 ) {
        	level++;
        	experience = 0;
        }else if (experience == 1000 && level == 17 ) {
        	level++;
        	experience = 0;
        }else if (experience == 1000 && level == 18 ) {
        	level++;
        	experience = 0;
        }else if (experience == 1000 && level == 19 ) {
        	level++;
        	experience = 0;
        }else if (experience == 1000 && level == 20 ) {
        	level++;
        	experience = 0;
        }
        
    }

    public void evolve() {
        //add code here
    }

    /// getters and setters 
	public SpeciesType getSpecies() {
		return species;
	}

	public void setSpecies(SpeciesType species) {
		this.species = species;
	}

	public GImage getSprite() {
		return sprite;
	}

	public void setSprite(GImage sprite) {
		this.sprite = sprite;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpatk() {
		return spatk;
	}

	public void setSpatk(int spatk) {
		this.spatk = spatk;
	}

	public int getSpdef() {
		return spdef;
	}

	public void setSpdef(int spdef) {
		this.spdef = spdef;
	}

	public Type getType1() {
		return type1;
	}

	public void setType1(Type type1) {
		this.type1 = type1;
	}

	public Type getType2() {
		return type2;
	}

	public void setType2(Type type2) {
		this.type2 = type2;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(  List<Move> moves ) {
		this.moves = moves;
	}
	
	public void addmove(  Move move ) {
		moves.add(move);
	}
	public void Switchmove( int num, Move move ) {
		moves.set(num, move);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void setRandomMoves() {
        Random rand = new Random();
        List<Move> availableMoves = new ArrayList<>();
        
        for (Move move : Move.values()) {
            availableMoves.add(move);
        }

        while (moves.size() < 4) {
            Move randomMove = availableMoves.get(rand.nextInt(availableMoves.size()));
           
            if (!moves.contains(randomMove)) {
                moves.add(randomMove);
            }
        }
    }
}


















