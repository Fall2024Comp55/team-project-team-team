
import java.util.List;
import java.util.ArrayList;
import acm.graphics.*;
import java.util.Random;
//finshed but need review:
public class Monster {

    private String name;
    private String description;
    private GImage sprite;

    private int curHealth;
    private int maxHealth;
    private double atk;
    private double def;
    
    private Type type1;
    private Type type2;
    private ArrayList<Move> moves;
    
    private int level;
    private int experience;
    private boolean fainted;
    
    public Monster(String name, String description , int hp, int attack, int defense,  Type type1, Type type2, int maxhealth, int level, String image) {
        this.name = name;
        this.description = description;
        this.sprite = new GImage(image);
        
        this.curHealth = hp;
        this.maxHealth = hp;
        this.atk = (double)attack;
        this.def = (double)defense;
        
        this.type1 = type1;
        this.type2 = type2;
        this.moves = new ArrayList<Move>();
        
        this.level = level;
        this.experience = lvlToExp(level);
        this.fainted = false;
    }
    
    Monster(SpeciesType specType, int level) {
    	this.name = specType.name;
        this.description = specType.description;
        this.sprite = specType.sprite;
        
        this.curHealth = specType.baseHP;
        this.maxHealth = specType.baseHP;
        this.atk = (double)specType.baseATK;
        this.def = (double)specType.baseDEF;
        
        this.type1 = specType.type1;
        this.type2 = specType.type2;
        this.moves = new ArrayList<Move>();
        
        this.level = level;
        this.experience = lvlToExp(level);
        this.fainted = false;
    }
    
    public int lvlToExp(int n) {
    	int xp = 0;
    	int next = 300;
    	for(int x = 0; x < n; x++) {
    		xp += next;
    		next += 100;
    	}
    	return xp;
    }
    
    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    
    public String getDescription() { return this.description; }
    
    public GImage getSprite() { return this.sprite; }
    
    public void updateHP(int hpChange) {
    	this.curHealth += hpChange;
    	if(this.curHealth <= 0) {
    		this.curHealth = 0;
    		this.fainted = true;
    	} else if(this.curHealth > this.maxHealth) {
    		this.curHealth = this.maxHealth;
    	}
    }
    
    public void fullHeal() {
    	this.curHealth = this.maxHealth;
    	this.fainted = false;
    }
    
    public boolean isFainted() {
        return fainted;
    }
    
    public int getAttack() {
        return (int)atk;
    }

    public int getDefense() {
        return (int)def;
    }

    public int getlevel() {
        return level;
    }
    
    
    public List<Move> getMoves1() {
        return moves;
    }
    
    
    
    public void gainXP(int xp) {
       this.experience = this.experience +  xp;
    }

    public void changeMove(int index, Move newMove) {
    	  this.moves.set(index, newMove);
    }

    public void updateLevel() {
    	if (experience == 22800) {
        	level = 20;
        } else if (experience >= 20700) {
        	level = 19;
        } else if (experience >= 18700) {
        	level = 18;
        } else if (experience >= 16800) {
        	level = 17;
        } else if (experience >= 15000) {
        	level = 16;
        } else if (experience >= 13300) {
        	level = 15;
        } else if (experience >= 11700) {
        	level = 14;
        } else if (experience >= 10200) {
        	level = 13;
        } else if (experience >= 8800) {
        	level = 12;
        } else if (experience >= 7500) {
        	level = 11;
        } else if (experience >= 6300) {
        	level = 10;
        } else if (experience >= 5200) {
        	level = 9;
        } else if (experience >= 4200) {
        	level = 8;
        } else if (experience >= 3300) {
        	level = 7;
        } else if (experience >= 2500) {
        	level = 6;
        } else if (experience >= 1800) {
        	level = 5;
        } else if (experience >= 1200) {
        	level = 4;
        } else if (experience >= 700) {
        	level = 3;
        } else if (experience >= 300) {
        	level = 2;
        } else {
        	level = 1;
        }
    }

    public void evolve() {
        //add code here
    }

    /// getters and setters


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

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setDef(int def) {
		this.def = def;
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

	public ArrayList<Move> getMoves() {
		return moves;
	}

	public void setMoves(  ArrayList<Move> moves ) {
		this.moves = moves;
	}
	
	public void addmove(  Move move ) {
		moves.add(move);
	}
	public void Switchmove( int num, Move move ) {
		moves.set(num, move);
	}

	public int getHealth() {
		return curHealth;
	}

	public void setHealth(int health) {
		this.curHealth = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
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


















