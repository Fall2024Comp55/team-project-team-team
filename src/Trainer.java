import java.util.ArrayList;
//test2
public class Trainer {
	private ArrayList<Monster> team;
	private int money;
	
	
	
	public Trainer() {
		team = new ArrayList<>();
		money = 0;
	}
	
	public ArrayList<Monster> getTeam(){
		return team;
	}
	
	public void setTeam(ArrayList<Monster> t) {
		team = t;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int amount) {
		money = amount;
	}
	
	
}
