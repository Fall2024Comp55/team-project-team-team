import java.util.List;
import java.util.ArrayList;
import acm.graphics.*;
//finshed but need review:
public class Monster {
	
	private SpeciesType species;
    private GImage sprite;
    private int experience = 0 ;
    private int level;
    private int atk;
    private int def;
    private int spatk;
    private int spdef;
    private int health;
    private Type type1;
    private Type type2;
    String name;
    private List<Move> moves;
    
    public Monster(String name, int hp, int attack, int defense, int level, List<Move> moves2) {
        this.name = name;
        this.health = hp;
        this.atk = attack;
        this.def = defense;
        this.level = level;
        this.moves = moves2;
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
    
    Monster(SpeciesType specType) {
    	this.species = specType;
    	this.experience = 0;
    	this.level = 1;
    	this.atk = species.getAttack();
    	this.def = species.getDefense();
    	this.health = species.getHealth();
    	this.type1 = species.getType1();
    	this.type2 = species.getType2();
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

	public void setMoves(ArrayList<Move> moves) {
		this.moves = moves;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}


















