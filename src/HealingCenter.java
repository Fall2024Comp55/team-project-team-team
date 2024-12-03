import java.util.ArrayList;
import java.util.HashMap;
	
public class HealingCenter extends PlayerTrainer {
	private String dialogue1 = "Hi i woulld you like to heal you monsters";
	private String dialogue2 = "You choose to heal";
	private String dialogue3 = "You choose not to heal";
	private String dialogue4 = "Thank you for stoping buy have a nice day";
	private boolean T_or_F = false;
		
	
	public void healing( PlayerTrainer p  ) {
		ArrayList<Monster> Monsters = p.getTeam(); 
		for (int i = 0; i < Monsters.size(); i++) {
		    int maxhealth = Monsters.get(i).getMaxHealth(); 
		    Monsters.get(i).fullHeal();;
		}
	 }
	

	public void Healing_dialogue( PlayerTrainer p  ) {
		System.out.println(dialogue1);
		if(T_or_F ) {
			System.out.println(dialogue2);
			healing(p);
		}else {
			System.out.println(dialogue3);
		}
		System.out.println(dialogue4);
	 }
	

}
