import java.util.Random;

public class BallItem {
	private double catchRate;
    
    public void Use() {
        if(catchRate > 0) {
        	Random rand = new Random();
        	double rate = rand.nextDouble();
        	if(rate >= 1.0 - catchRate) System.out.println("You have successfully caught the monster.");
        	else System.out.println("You failed to catch the monster.");
        }
    }
    
    public void setCatchRate(int i) {
    	//For now, I assume i is the index for the ball type.
    	switch(i) {
            case 1:
                this.catchRate = 0.25;
                break;
            case 2:
                this.catchRate = 0.5;
                break;
            case 3:
                this.catchRate = 0.75;
                break;
            case 4:
                this.catchRate = 1.0;
                break;
            default:
                System.out.println("Invalid ball");
                this.catchRate = 0;
    	}
    }
}
