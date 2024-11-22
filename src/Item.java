import acm.graphics.GImage;

public class Item {
	//private int amount;
	private ItemName itemName;
	private String description;
	private String bagTab;
	private GImage sprite;
	private Badge badge;
	//private ItemType itemType;
	
	
	public Item(ItemName name, BadgeType badgeType) {
		this.itemName = name;
		this.description = name.getDescription();
		this.bagTab = name.getBagTab();
		if(itemName == ItemName.BADGE && badgeType != null) badge = new Badge(badgeType);
	}
	public void Use(Monster m) {
		if(itemName.getBagTab() == "Heal") {
			System.out.println("Potion Tab");
			HealItem heal = new HealItem();
			heal.SetHeal(itemName.getType());
			heal.Use(m);
		}
		else if(itemName.getBagTab() == "Ball") {
			System.out.println("Ball Tab");
			BallItem ball = new BallItem();
			ball.setCatchRate(itemName.getType());
			ball.Use();
		}
		else {
			System.out.println("Badge Tab");
		}
	}
	
	public ItemName getName() {
		return itemName;
	}
	
	public void setName(ItemName name) {
		itemName = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String d) {
		description = d;
	}
	
	public String bagTab() {
		return bagTab;
	}
	
	public GImage getSprite(){
		return sprite;
	}
}
