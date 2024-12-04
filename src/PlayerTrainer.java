import java.util.ArrayList;

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
		 this.team = new ArrayList<Monster>();
		 this.team.add(new Monster(SpeciesType.SHADOWMATH, 5));
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
		String currentTab = bag.getCurrentTab();
	    System.out.println("Currently viewing " + currentTab + " tab.");

	    for (Pair<Item, Integer> pair : bag.getItems()) {
	        Item item = pair.getKey();
	        if (currentTab.equals("Heal") && item.getBagTab().equals("Heal")) {
	            System.out.println(item.getName() + " - Quantity: " + pair.getValue());
	        } else if (currentTab.equals("Ball") && item.getBagTab().equals("Ball")) {
	            System.out.println(item.getName() + " - Quantity: " + pair.getValue());
	        } else if (currentTab.equals("Badge") && item.getBagTab().equals("Badge")) {
	            System.out.println(item.getName() + " - Quantity: " + pair.getValue());
	        }
	    }
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
