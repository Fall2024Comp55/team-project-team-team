import java.util.*;
import acm.graphics.*;

public class Monster {
	private SpeciesType species;
    private GImage sprite;
    private int experience;
    private int level;
    private int atk;
    private int def;
    private int spatk;
    private int spdef;
    private Type type1;
    private Type type2;
    private ArrayList<Move> moves;
    
    
    public boolean updateHP(int hpChange) {
        //add code here
        return false;
    }

    public void gainXP(int xp) {
        //add code here
    }

    public void changeMove(int index, Move newMove) {
        //add code here
    }

    public void levelUp() {
        //add code here
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

	public ArrayList<Move> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<Move> moves) {
		this.moves = moves;
	}
}
