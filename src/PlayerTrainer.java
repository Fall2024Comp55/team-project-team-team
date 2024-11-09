
public class PlayerTrainer extends Trainer{
	private int numBadges;
	private int currMoney;
	private Bag bag;
	private Direction direction;
	
	
	public PlayerTrainer() {
		 numBadges = 0;
		 currMoney = 0;
		 bag = new Bag();
		 this.direction = Direction.DOWN;
	 }
	
	public void updateMoney(int amount) {
		currMoney = currMoney + amount;
	}
	
	public int getNumBadges(){
		return numBadges;
	}
	
	public void addNumBadges() {
		numBadges++;
	}
	
	public void openBag() {
		//bag = new Bag();
		System.out.println("Opening bag with " + bag.getItems().size()+ " items.");
		//rest of bag menu
	}
	
	public Bag getBag() {
		return bag;
	}
	
	 public void setDirection(Direction direction) {
		 this.direction = direction; 
	 }
	 
	 public Direction getDirection() {
		 return direction;
	 }
	 
	 
	
}
