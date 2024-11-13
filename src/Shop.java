import java.util.HashMap;
public class Shop {
	//HashMap<Item Name, Price>
    private HashMap<ItemName, Integer> itemList;
  //HashMap<Item Name, Quantity>
    private HashMap<ItemName, Integer> itemQuantity;
    private PlayerTrainer player;
    private Bag playerBag;
    
    public Shop() {
    	this.player = new PlayerTrainer();
    	this.playerBag = player.getBag();
    	
    	itemList = new HashMap<>();
    	itemList.put(ItemName.POTION, 100);
    	itemList.put(ItemName.BIGPOTION, 200);
    	itemList.put(ItemName.MAXPOTION, 300);
    	itemList.put(ItemName.BASICBALL, 400);
    	itemList.put(ItemName.SUPERBALL, 500);
    	
    	itemQuantity = new HashMap<>();
    	itemQuantity.put(ItemName.POTION, 20);
    	itemQuantity.put(ItemName.BIGPOTION, 20);
    	itemQuantity.put(ItemName.MAXPOTION, 20);
    	itemQuantity.put(ItemName.BASICBALL, 20);
    	itemQuantity.put(ItemName.SUPERBALL, 20);
    }
    public void displayMenu() {
    	System.out.println("Menu:");
        for (ItemName itemName : itemList.keySet()) {
            int price = itemList.get(itemName);
            int quantity = itemQuantity.get(itemName);
            System.out.println(itemName + ": $" + price + " (Remains: " + quantity + ")");
        }
    }
    
    public void buy(ItemName name, int quantity) {
    	if (!itemList.containsKey(name) || !itemQuantity.containsKey(name)) {
            System.out.println("Item not available.");
            return;
        }
    	int shopQuantity =  itemQuantity.get(name);
    	if(shopQuantity < quantity) {
    		System.out.println("Out of stock. Please select another quantity");
    		return;
    	} else {
    		shopQuantity -= quantity;
    		itemQuantity.remove(name);
    		itemQuantity.put(name, shopQuantity);
    		player.updateMoney(quantity);
    		Pair<Item, Integer> newItem = new Pair<>(new Item(name), quantity);
    		playerBag.addItem(newItem);
    		System.out.println("Thank you for buying");
    	}
    }
    
    public void sell(ItemName name, int amount) {
        int total = 0;
        int itemPrice = itemList.get(name);
        //the selling price is 75% of original price
        total = (itemPrice * 3 / 4) * amount;
        playerBag.removeItem(new Item(name), amount);
        player.updateMoney(total);
    }
}
