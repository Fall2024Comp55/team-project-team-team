import java.util.ArrayList;
import java.util.HashMap;
	
public class HealingCenter extends PlayerTrainer {
 
	
	public void healing( PlayerTrainer p  ) {
		ArrayList<Monster> Monsters = p.getTeam(); 
		for (int i = 0; i < Monsters.size(); i++) {
		    int maxhealth = Monsters.get(i).getMaxHealth(); 
		    Monsters.get(i).setHealth(maxhealth);
		}
	 }
	
	
	    
	   
	

}
