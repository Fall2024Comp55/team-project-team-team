import java.util.ArrayList;
import java.util.Random;
//test2
public class Trainer {
	private String name;
	private ArrayList<Monster> team;
	private int money;
	
	public Trainer(Trainers trainer) {
		this.name = trainer.name;
		for(int x = 0; x < trainer.team.length; x++) {
			team.add(trainer.team[x]);
		}
		this.money = trainer.money;
	}
	
	public Trainer() {
		team = new ArrayList<Monster>();
		money = 0;
	}
	
	public ArrayList<Monster> getTeam(){
		return team;
	}
	
	public void setTeam(ArrayList<Monster> t) {
		team = t;
	}
	
	public void addMon(Monster m) {
		 team.add(m);
	}
	
	public Monster switchMon(int num) {
        if (num >= 0 && num < team.size()) {
            return team.get(num); // Return the monster at the specified index
        } else {
            System.out.println("Invalid index for switching monsters.");
            return null;
        }
    }
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int amount) {
		money = amount;
	}
	
	public void setRandomTeam() {
	    Random rand = new Random();
	    
	    SpeciesType[] availableSpecies = SpeciesType.values();

	    for (int i = 0; i < 4; i++) {
	        SpeciesType species = availableSpecies[rand.nextInt(availableSpecies.length)];

	        Monster randomMonster = new Monster(species ,5); // Assuming Monster constructor takes SpeciesType

	        team.add(randomMonster);
	    }
	}
	
		
}
