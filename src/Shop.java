import java.util.HashMap;
public class Shop {
	//HashMap<Item Name, Price>
    private HashMap<String, Integer> itemList;
  //HashMap<Item Name, Quantity>
    private HashMap<String, Integer> itemQuantity;
    private PlayerTrainer player;
    private Bag playerBag;
    
    public Shop() {
    	this.player = new PlayerTrainer();
    	this.playerBag = player.getBag();
    	
    	itemList = new HashMap<>();
    	itemList.put("POTION", 100);
    	itemList.put("BIGPOTION", 200);
    	itemList.put("MAXPOTION", 300);
    	itemList.put("BASICBALL", 400);
    	itemList.put("SUPERBALL", 500);
    	
    	itemQuantity = new HashMap<>();
    	itemQuantity.put("POTION", 20);
    	itemQuantity.put("BIGPOTION", 20);
    	itemQuantity.put("MAXPOTION", 20);
    	itemQuantity.put("BASICBALL", 20);
    	itemQuantity.put("SUPERBALL", 20);
    }
    public void displayMenu() {
    	System.out.println("Menu:");
        for (String itemName : itemList.keySet()) {
            int price = itemList.get(itemName);
            int quantity = itemQuantity.get(itemName);
            System.out.println(itemName + ": $" + price + " (Remains: " + quantity + ")");
        }
    }
    
    public void buy(String name, int quantity) {
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
    		//need Item constructor to add new item into bag
    		Pair<Item, Integer> newItem = new Pair<>(new Item(), quantity);
    		playerBag.addItem(newItem);
    		System.out.println("Thank you for buying");
    	}
    }
    
    public void sell(String name, int amount) {
        int total = 0;
        int itemPrice = itemList.get(name);
        total = (itemPrice * 3 / 4) * amount;
        player.updateMoney(total);
    }
}
