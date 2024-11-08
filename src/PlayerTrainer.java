import java.util.ArrayList;

public class PlayerTrainer {
	private Trainer trainer;
	private int numBadges;
	private int currMoney;
	private Bag bag;
	
	public void updateMoney(int amount) {
		currMoney = currMoney + amount;
	}
	
	public void updatenumBadges(int numBadge) {
		this.numBadges = this.numBadges + numBadge;
	}
	
	public void openBag() {
		bag = new Bag();
	}
	
	public void trainerSetTeam(ArrayList<Monster> t){
		this.trainer.setTeam(t);
	}
	public ArrayList<Monster> trainergetTeam(){
		return (this.trainer.getTeam());
	}
	
	
	
}
