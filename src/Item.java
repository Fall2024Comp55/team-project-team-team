import acm.graphics.GImage;

public class Item {
	private int amount;
	private String itemName;
	private String description;
	private String bagTab;
	private GImage sprite;
	
	public void Use() {
		
	}
	
	public String getName() {
		return itemName;
	}
	
	public void setName(String name) {
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
