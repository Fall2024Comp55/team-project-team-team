import java.util.Random;

public class BallItem {
	private int catchRate;
    
    public void Use() {
        if(catchRate > 0) {
        	Random rand = new Random();
        	//regenerate random integer number from 0 to 100
        	int rate = rand.nextInt(101);
        	//if user uses ball with 25% catch rate, I assume that the user has 25 out 100 chance to catch the monster
        	//calculate 100 - 25 = 75
        	//If the rate is greater or equals to 75 (75 <= rate <= 100) (let says 80), the user fall into 1 in 25 successful cases
        	if(rate >= 100 - catchRate) System.out.println("You have successfully caught the monster.");
        	else System.out.println("You failed to catch the monster.");
        }
    }
    
    public void setCatchRate(int i) {
    	//For now, I assume i is the index for the ball type.
    	switch(i) {
            case 1:
                this.catchRate = 25;
                break;
            case 2:
                this.catchRate = 50;
                break;
            case 3:
                this.catchRate = 75;
                break;
            case 4:
                this.catchRate = 100;
                break;
            default:
                System.out.println("Invalid ball");
                this.catchRate = 0;
    	}
    }
}
