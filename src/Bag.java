import java.util.ArrayList;

public class Bag {
	private ArrayList<Pair<Item, Integer> >items;
	
	public ArrayList<Pair<Item, Integer>> getItems(){
		return items;
	}
	
	public void setItems(ArrayList<Pair<Item, Integer>> bagItems) {
		this.items = bagItems;
	}
	
	public void addItem(Pair<Item, Integer> bagItem) {
		items.add(bagItem);
	}
	
	public Bag() {
		items = null;
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
						return;
					}
					
				}
		}
	}
}
	