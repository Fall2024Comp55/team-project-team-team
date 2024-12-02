import java.util.ArrayList;
//test2
public class Bag {
	private ArrayList<Pair<Item, Integer> >items;
	private String currentTab;
	
	public Bag() {
		items = new ArrayList<>();
		currentTab = "Heal"; // assume this is the first tab appear when open bag
	}
	
	public ArrayList<Pair<Item, Integer>> getItems(){
		return items;
	}
	
	public Pair<Item, Integer> getItemByName(ItemName itemName) {
	    for (Pair<Item, Integer> item : items) {
	        if (item.getKey().getName() == itemName) {
	            return item;
	        }
	    }
	    return null;
	}
	
	public void setItems(ArrayList<Pair<Item, Integer>> bagItems) {
		this.items = bagItems;
	}
	
	public void addItem(Pair<Item, Integer> bagItem) {
		items.add(bagItem);
	}
	
	
	
	//@SuppressWarnings("unlikely-arg-type")
	public void removeItem(Item key, int amount) {
		for(int i = 0; i < items.size(); i++) {
			Pair<Item, Integer> item = items.get(i);
				if(item.getKey().equals(key)) {
					int currentAmount = item.getValue();
					int newAmount = currentAmount - amount;
					if(amount > 0 ) {
						item.setValue(newAmount);
					}
					else {
						items.remove(i);
					}
					return;
					
				}
		}
	}
	
	public void changeTab(String tab) {
        if (tab.equalsIgnoreCase("Heal") || tab.equalsIgnoreCase("Ball") || tab.equalsIgnoreCase("Badge")) {
            currentTab = tab;
        } else {
            return;
        }
    }
	
	public void setCurrentTab(String tab) {
        this.currentTab = tab;
    }
	
	public String getCurrentTab() {
        return currentTab;
    }
}
	