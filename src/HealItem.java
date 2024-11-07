
public class HealItem {
    private int heal;
     
    public void Use(Monster m) {
    	if(heal > 0) m.updateHP(heal);
    }
    
    public void SetHeal(int i) {
    	//For now, I assume i is the index for the heal item type.
    	switch(i) {
            case 1:
                this.heal = 20;
                break;
            case 2:
                this.heal = 40;
                break;
            case 3:
                this.heal = 60;
                break;
            case 4:
                this.heal = 80;
                break;
            default:
                System.out.println("Invalid heal item");
                this.heal = 0;
        }
    }
}
