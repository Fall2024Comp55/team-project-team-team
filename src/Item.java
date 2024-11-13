import acm.graphics.GImage;

public class Item {
	private int amount;
	private ItemName itemName;
	private String description;
	private String bagTab;
	private GImage sprite;
	//private ItemType itemType;
	
	public Item(ItemName name) {
		this.itemName = name;
	}
	public void Use() {
		
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
