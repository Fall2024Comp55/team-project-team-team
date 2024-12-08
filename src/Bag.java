import java.util.ArrayList;

public class Bag {
    private ArrayList<Item> items;
    private String currentTab;

    public Bag() {
        items = new ArrayList<Item>();
        initializeItems();
        currentTab = "Heal";
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItemByName(ItemName itemName) {
        for (Item item : items) {
            if (item.getName() == itemName) {
                return item;
            }
        }
        return null;
    }
    
    public int getItemQuantity(ItemName itemName) {
        for (Item item : items) {
            if (item.getName() == itemName) {
                return item.getAmount();
            }
        }
        return 0; // Return 0 if the item is not found
    }

    public void addItem(Item newItem) {
        for (Item item : items) {
            if (item.getName() == newItem.getName()) {
                // If the item already exists, increase the amount
                item.setAmount(item.getAmount() + newItem.getAmount());
                return;
            }
        }
        // If the item does not exist, add it as a new entry
        items.add(newItem);
    }
 
    public void removeItem(Item item) {
        items.remove(item);
    }

    public void changeTab(String tab) {
        if (tab.equalsIgnoreCase("Heal") || tab.equalsIgnoreCase("Ball") || tab.equalsIgnoreCase("Badge")) {
            currentTab = tab;
        }
    }
    private void initializeItems() {
        // Add initial items to the bag
        addItem(new Item(ItemName.POTION, null, 5));
        addItem(new Item(ItemName.POTION, null, 3)); // Will consolidate with the above
        addItem(new Item(ItemName.SUPERPOTION, null, 2));
    }

    public String getCurrentTab() {
        return currentTab;
    }
}