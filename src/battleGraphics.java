import acm.program.*;
import acm.graphics.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import java.util.Timer;
import java.util.TimerTask;


public class battleGraphics extends GraphicsProgram {
	
	PlayerTrainer playerTrainer;
	Trainer enemy ;
	Monster playerMonster;
	Monster trainerMonster;
	
	
    private int screenWidth  = 720;
    private int screenHeight = 560;
    
    private GImage background;
    
    private GImage battleScreen ;
    private GImage fighticon;
    private GImage bagicon;
    private GImage Monstericon;
    private GImage runicon;
    
    private GImage bscreen;
    private GImage exit;
    private GImage move1;
    private GImage move2;
    private GImage move3;
    private GImage move4;
    
    private GImage trainterMon;
    private GImage playerMon;
    private boolean isPlayerTurn;
    
    
    public void setplayer(PlayerTrainer playerTrainer,Trainer enemy  ) {
       this.playerTrainer = playerTrainer;
       this.enemy = enemy;
    }
    

    public void init() {
        setSize(screenWidth, screenHeight);  
        addKeyListeners();                   
        requestFocus();                      
    }
    
    
    public void clearIconsB() {
        if (fighticon != null) {
            remove(fighticon);
            fighticon = null; 
        }
        if (bagicon != null) {
            remove(bagicon);
            bagicon = null;  
        }
        if (Monstericon != null) {
            remove(Monstericon);
            Monstericon = null;  
        }
        if (runicon != null) {
            remove(runicon);
            runicon = null;  
        }
        if (battleScreen != null) {
            remove(battleScreen);
            battleScreen = null;  
        }
    }
    
    
    public void setupMainB() {
        
        
        battleScreen = new GImage("battle.png");  
        battleScreen.setSize(720, 180);
        battleScreen.setLocation(0, 380);
        
        bagicon = new GImage("bagicon.png"); 
        bagicon.setSize(210, 90);
        bagicon.setLocation(520, 400);
        
        fighticon = new GImage("fighticon.png"); 
        fighticon.setSize(210, 90);
        fighticon.setLocation(340, 390);
        
        Monstericon = new GImage("Monstericon.png"); 
        Monstericon.setSize(210, 90);
        Monstericon.setLocation(335, 470);
        
        runicon = new GImage("runicon.png"); 
        runicon.setSize(210, 90);
        runicon.setLocation(510, 470);
        
        
        add(battleScreen);
        add(fighticon);
        add(bagicon);
        add(Monstericon);
        add(runicon);
    }
    
    public void clearIconsF() {
       
    	if (bscreen != null) {
            remove(bscreen);
            bscreen = null; 
        }
        if (exit != null) {
            remove(exit);
            exit = null;  
        }
        if (move1 != null) {
            remove(move1);
            move1 = null;  
        }
        if (move2 != null) {
            remove(move2);
            move2 = null;  
        }
        if (move3 != null) {
            remove(move3);
            move3 = null; 
        }
        
        if (move4 != null) {
            remove(move4);
            move4 = null; 
        }
    }
    
    public void setupMainF() {
    	clearIconsB();
    	
    	bscreen = new GImage("Battle_Moves.png"); 
    	bscreen.setSize(720,180);
    	bscreen.setLocation(0,380);
    	
    	exit = new GImage("exit.png"); 
    	exit.setSize(165,165);
    	exit.setLocation(545,390);
    	
    	move1 = new GImage("move.png"); 
    	move1.setSize(265,90);
    	move1.setLocation(5,385);
    	
    	move2 = new GImage("move.png"); 
    	move2.setSize(265,90);
    	move2.setLocation(273,385);
    	
    	move3 = new GImage("move.png"); 
    	move3.setSize(265,90);
    	move3.setLocation(5,467);
    	
    	move4 = new GImage("move.png"); 
    	move4.setSize(265,90);
    	move4.setLocation(273,467);
    	
    	
    	
        add(bscreen);
        add(exit); 
        add(move1);
        add(move2);
        add(move3);
        add(move4);
       
    }
    
   
  
    public void run() {
    	background = new GImage("grassbackground.png"); 
    	background.setSize(720,390);
    	add(background);
    	
    		
    	setupMainB();
    	
    	if (playerTrainer != null && enemy != null) {
    		trainerMonster = enemy.getTeam().getFirst();
            trainterMon = trainerMonster.getImage();
            trainterMon.setLocation(535,230);
            
           
            
            playerMonster = playerTrainer.getTeam().get(0);
            playerMon = playerMonster.getImage();
            playerMon.setLocation(158,363);
            
            
            add(trainterMon);
            add(playerMon);
        }
        
        addMouseListeners();
        
    }
    

  
    public void mousePressed(MouseEvent e) {
    	int x = e.getX();
        int y = e.getY();
        
        // clears everything 
        if (runicon != null && runicon.contains(x, y)) {
            clearIconsB(); 
            
            
            if (background != null) {
            	remove(background);
            	background = null;
            }
            if(trainterMon != null) {
            	remove(trainterMon);
            	trainterMon = null;
            }
            if(playerMon != null) {
            	remove(playerMon);
            	playerMon = null;
            }
           

        }
        
        if (fighticon != null && fighticon.contains(x, y)) {
            setupMainF();  
        }
        
        if (exit != null && exit.contains(x, y)) {
            clearIconsF(); 
            setupMainB(); 
        }
        
        
        if(move1 != null && move1.contains(x, y)  && playerMonster.getMoves().size() > 0  ) {
        	Move move = playerMonster.getMoves().get(0);
        	int damage = move.calculateDamage(playerMonster, trainerMonster);
        	moveAnimation(playerMonster.getMoves().get(0).getName());
        	playerMonster.updateHP(-damage);
        	
        	Move move2 = selectRandomMove(trainerMonster);
            int damage2 = move2.calculateDamage(trainerMonster, playerMonster);
            playerMonster.updateHP(-damage2);
            
            clearIconsF(); 
            setupMainB(); 
        	
        }
        if(move2 != null && move1.contains(x, y) &&  playerMonster.getMoves().size() > 1  ) {
        	Move move = playerMonster.getMoves().get(1);
        	int damage = move.calculateDamage(playerMonster, trainerMonster);
        	moveAnimation(playerMonster.getMoves().get(1).getName());
        	playerMonster.updateHP(-damage);
        	
        	Move move2 = selectRandomMove(trainerMonster);
            int damage2 = move2.calculateDamage(trainerMonster, playerMonster);
            playerMonster.updateHP(-damage2);
            
            clearIconsF(); 
            setupMainB(); 
        }
        if(move3 != null && move1.contains(x, y) &&  playerMonster.getMoves().size() > 2  ) {
        	Move move = playerMonster.getMoves().get(2);
        	int damage = move.calculateDamage(playerMonster, trainerMonster);
        	moveAnimation(playerMonster.getMoves().get(2).getName());
        	playerMonster.updateHP(-damage);
        	
        	Move move2 = selectRandomMove(trainerMonster);
            int damage2 = move2.calculateDamage(trainerMonster, playerMonster);
            playerMonster.updateHP(-damage2);
            
            clearIconsF(); 
            setupMainB(); 
        	
        }
        if(move4 != null && move1.contains(x, y) &&  playerMonster.getMoves().size() > 3  ) {
        	Move move = playerMonster.getMoves().get(3);
        	int damage = move.calculateDamage(playerMonster, trainerMonster);
        	moveAnimation(playerMonster.getMoves().get(3).getName());
        	playerMonster.updateHP(-damage);
        	
        	Move move2 = selectRandomMove(trainerMonster);
            int damage2 = move2.calculateDamage(trainerMonster, playerMonster);
            playerMonster.updateHP(-damage2);
            
            clearIconsF(); 
            setupMainB(); 
        }
        
        
        
        if (bagicon != null && bagicon.contains(x, y)) {
            // Handle Bag icon click (not implemented here)
        }
        if (Monstericon != null && Monstericon.contains(x, y)) {
            // Handle Monster icon click (not implemented here)
        }
   
        System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
    }
    

private Move selectRandomMove(Monster trainerMonster2) {
		// TODO Auto-generated method stub
		return null;
	}


public void moveAnimation(String moveName) {
   
    if (moveName.equals("Tackle")) {
        animateTackle();
    } else if (moveName.equals("Ember")) {
        //animateEmber();
    } else if (moveName.equals("Flamethrower")) {
       animateFlamethrower();
    } else if (moveName.equals("Fire Blast")) {
       animateFireBlast();
    } else if (moveName.equals("Water Gun")) {
        animateWaterGun();
    } else if (moveName.equals("Surf")) {
       // animateSurf();
    } else if (moveName.equals("Thunderbolt")) {
        //animateThunderbolt();
    } else if (moveName.equals("Earthquake")) {
       // animateEarthquake();
    } 
   
}

private void animateTackle() {
    // Create the tackle effect image
    GImage tackleEffect = playerMonster.getImage();  
    //tackleEffect.setSize(100, 100);  
    tackleEffect.setLocation(158, 363);  
    add(tackleEffect);

    
    final int targetX = 535;
    final int targetY = 230;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - tackleEffect.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - tackleEffect.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - tackleEffect.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - tackleEffect.getY()) / (totalFrames - framesMoved));

               
                tackleEffect.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                playerMon.setLocation(158,363);
            }
        }
    }, 0, 30); 
    
}

private void animateFireBlast() {
    // Create the tackle effect image
    GImage FireBlast = new GImage("FireAttack.png");  
    //tackleEffect.setSize(100, 100);  
    FireBlast.setSize(30, 30);
    FireBlast.setLocation(158, 363);  
    add(FireBlast);

    
    final int targetX = 535;
    final int targetY = 230;

   
    final int moveDistance = 10;

    // Calculate the total number of frames needed to move horizontally and vertically
    // We divide the distance by the move distance, rounded up, so it covers the full distance
    final int totalFramesX = (int) Math.ceil((double) Math.abs(targetX - FireBlast.getX()) / moveDistance);
    final int totalFramesY = (int) Math.ceil((double) Math.abs(targetY - FireBlast.getY()) / moveDistance);

    // We want to take the maximum of both X and Y frame counts so the image finishes in sync
    final int totalFrames = Math.max(totalFramesX, totalFramesY);

    // Create a timer to animate the image's movement
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        private int framesMoved = 0;

        @Override
        public void run() {
            if (framesMoved < totalFrames) {
               
                int moveX = (int) ((targetX - FireBlast.getX()) / (totalFrames - framesMoved));
                int moveY = (int) ((targetY - FireBlast.getY()) / (totalFrames - framesMoved));

               
                FireBlast.move(moveX, moveY);

                framesMoved++;
            } else {
                
                cancel();
                remove(FireBlast);
            }
        }
    }, 0, 30); 
    
}


private void animateFlamethrower() {
    
    int numFireBlasts = 25;

    final int targetX = 535;
    final int targetY = 230;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("FireAttack.png");  
        fireBlast.setSize(30, 30);  
        
        fireBlast.setLocation(158, 363);
        add(fireBlast);
        fireBlasts[i] = fireBlast;  
    }

   
    Timer launchTimer = new Timer();
    launchTimer.scheduleAtFixedRate(new TimerTask() {
        private int currentBlastIndex = 0;  

        @Override
        public void run() {
            if (currentBlastIndex < numFireBlasts) {
                
                GImage currentBlast = fireBlasts[currentBlastIndex];

               
                animateFireBlast(currentBlast, targetX, targetY, moveDistance);

                currentBlastIndex++;
            } else {
                cancel();  
            }
        }
    }, 0, 100);  
}


private void animateFireBlast(GImage fireBlast, final int targetX, final int targetY, final int moveDistance) {
    Timer moveTimer = new Timer();
    moveTimer.scheduleAtFixedRate(new TimerTask() {
        

        @Override
        public void run() {
           
            double deltaX = targetX - fireBlast.getX();
            double deltaY = targetY - fireBlast.getY();

           
            double totalDistance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

          
            if (totalDistance > moveDistance) {
               
                double moveRatioX = deltaX / totalDistance;
                double moveRatioY = deltaY / totalDistance;

                
                int moveX = (int) (moveRatioX * moveDistance);
                int moveY = (int) (moveRatioY * moveDistance);

              
                fireBlast.move(moveX, moveY);
            } else {
               
                fireBlast.setLocation(targetX, targetY);
                remove(fireBlast);  
                cancel();  
            }

          
        }
    }, 0, 30); 
}


private void animateWaterGun() {
    
    int numFireBlasts = 25;

    final int targetX = 535;
    final int targetY = 230;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("bubble.png");  
        fireBlast.setSize(30, 30);  
        
        fireBlast.setLocation(158, 363);
        add(fireBlast);
        fireBlasts[i] = fireBlast;  
    }

   
    Timer launchTimer = new Timer();
    launchTimer.scheduleAtFixedRate(new TimerTask() {
        private int currentBlastIndex = 0;  

        @Override
        public void run() {
            if (currentBlastIndex < numFireBlasts) {
                
                GImage currentBlast = fireBlasts[currentBlastIndex];

               
                animateFireBlast(currentBlast, targetX, targetY, moveDistance);

                currentBlastIndex++;
            } else {
                cancel();  
            }
        }
    }, 0, 100);  
}









    // Main method to launch the program
    public static void main(String[] args) {
    	PlayerTrainer playerTrainer = new PlayerTrainer();
	    Monster playerMonster = new Monster(SpeciesType.SPIDER,5);
	    playerMonster.addmove(Move.WATERGUN);
	    playerMonster.addmove(Move.EMBER);
	    
	    // Add the monster to the player's team
	    playerTrainer.addMon(playerMonster);	
	    
	    
	    Trainer opponentTrainer = new Trainer();
	    Monster opponentMonster = new Monster(SpeciesType.FLAMECLAW,5);
	    opponentMonster.addmove(Move.FLAMETHROWER);
	    opponentMonster.addmove(Move.EMBER);
	    opponentMonster.addmove(Move.EARTHQUAKE);
	    opponentMonster.addmove(Move.WATERGUN);
	    opponentTrainer.addMon(opponentMonster);
	    
	    
    	  battleGraphics s = new battleGraphics();
    	  s.setplayer(playerTrainer,opponentTrainer);
    	  s.start();
    }

}