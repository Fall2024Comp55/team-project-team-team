import acm.program.*;
import acm.graphics.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Timer;
import java.util.TimerTask;

public class battleGraphics  {
    
	private Map map;
	private double screenSizeX;
	private double screenSizeY;
	
    Trainer player;
    Trainer opponent;
    Monster playerMonster;
    Monster opponentMonster;
    Monster wildMonster;
    
    private GImage playerMonsterSprite;
    private GImage opponentMonsterSprite;
    
    private GImage background;
    private GImage battleScreen;
    
    private GImage fighticon;
    private GImage Monstericon;
    private GImage bagicon;
    private GImage runicon;
    
    private GImage bscreen;
    private GImage exit;
    
    private GImage move1;
    private GImage move2;
    private GImage move3;
    private GImage move4;
    
    private boolean isPlayerTurn;
    
    public battleGraphics(Map map, Trainer player, Trainer opponent) {
    	this.map = map;
    	this.screenSizeX = map.getWidth();
    	this.screenSizeY = map.getHeight();
    	
    	this.player = player;
    	this.opponent = opponent;
    	this.playerMonster = player.getTeam().get(0);
    	this.opponentMonster = opponent.getTeam().get(0);
    	
    	this.playerMonsterSprite = player.getTeam().get(0).getBackSprite();
    	this.opponentMonsterSprite = opponent.getTeam().get(0).getFrontSprite();
    }
    
    public battleGraphics(Map map, Trainer player, Monster wildMonster) {
    	this.map = map;
    	this.screenSizeX = map.getWidth();
    	this.screenSizeY = map.getHeight();
    	
    	this.player = player;
    	this.wildMonster = wildMonster;
    	this.playerMonster = player.getTeam().get(0);
    	
    	this.playerMonsterSprite = player.getTeam().get(0).getBackSprite();
    	this.opponentMonsterSprite = wildMonster.getFrontSprite();
    }
    
    public void init() {
    	this.background = new GImage("grassBackground.png");
    	this.battleScreen = new GImage("battle.png");
    	
    	this.fighticon = new GImage("fighticon.png");
    	this.Monstericon = new GImage("Monstericon.png");
    	this.bagicon = new GImage("bagicon.png");
    	this.runicon = new GImage("runicon.png");
    	
    	this.bscreen = new GImage("Battle_Moves.png");
    	this.exit = new GImage("exit.png");
    	
    	this.move1 = new GImage("move.png");
    	this.move2 = new GImage("move.png");
    	this.move3 = new GImage("move.png");
    	this.move4 = new GImage("move.png");
    	
       // addKeyListeners();                   
        //requestFocus();                      
    }
    
    public void clearIconsB() {
        map.remove(fighticon);
        map.remove(bagicon);
        map.remove(Monstericon);
        map.remove(runicon);
        map.remove(battleScreen);
    }

    public void setupMainB() {
        battleScreen = new GImage("battle.png");  
        battleScreen.setSize(880, 200); 
        battleScreen.setLocation(0, 520); 
        
        bagicon = new GImage("bagicon.png"); 
        bagicon.setSize(250, 100);
        bagicon.setLocation(635, 540);
        
        fighticon = new GImage("fighticon.png"); 
        fighticon.setSize(250, 100);
        fighticon.setLocation(420, 535); // Adjust location for new screen size
        
        Monstericon = new GImage("Monstericon.png"); 
        Monstericon.setSize(250, 100);
        Monstericon.setLocation(415, 620); // Adjust location for new screen size
        
        runicon = new GImage("runicon.png"); 
        runicon.setSize(250, 100);
        runicon.setLocation(630, 620); // Adjust location for new screen size
        
        map.add(battleScreen);
        map.add(fighticon);
        map.add(bagicon);
        map.add(Monstericon);
        map.add(runicon);
    }

    public void clearIconsF() {
        	map.remove(bscreen);
        	map.remove(exit);
        	map.remove(move1);
        	map.remove(move2);
        	map.remove(move3);  
        	map.remove(move4);
    }

    public void setupMainF() {
        clearIconsB();
        
        
        bscreen.setSize(880, 200); 
        bscreen.setLocation(0, 520); 
        
        exit = new GImage("exit.png"); 
        exit.setSize(200, 180);
        exit.setLocation(670, 530); 
        
        move1 = new GImage("move.png"); 
        move1.setSize(327, 98);
        move1.setLocation(5, 530); 
        
        move2 = new GImage("move.png"); 
        move2.setSize(327, 98);
        move2.setLocation(330, 530); 
        
        move3 = new GImage("move.png"); 
        move3.setSize(327, 98);
        move3.setLocation(5, 620);
        
        move4 = new GImage("move.png"); 
        move4.setSize(327, 98);
        move4.setLocation(330, 620);
        
        map.add(bscreen);
        map.add(exit); 
        map.add(move1);
        map.add(move2);
        map.add(move3);
        map.add(move4);
    }

    public void run() {
    	background.setSize(screenSizeX ,  screenSizeY - 200);
        map.add(background);
        
        setupMainB();
        
        playerMonsterSprite.setSize(50, 50);
        playerMonsterSprite.setLocation(200, 460); 
        map.add(playerMonsterSprite);
        
        opponentMonsterSprite.setSize(50, 50);
        opponentMonsterSprite.setLocation(630, 280);
        map.add(opponentMonsterSprite);
        
       // addMouseListeners();
    }
  
    public void mousePressed(MouseEvent e) {
    	int x = e.getX();
        int y = e.getY();
        
        // clears everything 
        if ( map.getElementAt(x, y) == runicon ) {
            clearIconsB(); 
            clearIconsF();
            
            map.remove(background);
            map.remove(opponentMonsterSprite);
            map.remove(playerMonsterSprite); 	
            map.endBattle();
        }
        
        if (map.getElementAt(x, y) == fighticon ) {
            setupMainF();  
        }
        
        if (map.getElementAt(x, y) == exit ) {
            clearIconsF(); 
            setupMainB(); 
        }
        
        if(map.getElementAt(x, y) == move1 &&  playerMonster.getMoves().size() > 0 ) {
        	Move move = playerMonster.getMoves().get(0);
        	int damage = move.calculateDamage(playerMonster, opponentMonster);
        	moveAnimation(playerMonster.getMoves().get(0).getName());
        	playerMonster.updateHP(-damage);
        	
        	Move move2 = selectRandomMove(opponentMonster);
            int damage2 = move2.calculateDamage(opponentMonster, playerMonster);
            moveAnimationTrainer(move2.getName());
            playerMonster.updateHP(-damage2);
           
            
            clearIconsF(); 
            setupMainB(); 
        }
        
     
        if( map.getElementAt(x, y) == move2  &&  playerMonster.getMoves().size() > 1  ) {
        	Move move = playerMonster.getMoves().get(1);
        	int damage = move.calculateDamage(playerMonster, opponentMonster);
        	moveAnimation(playerMonster.getMoves().get(1).getName());
        	playerMonster.updateHP(-damage);
        	
        	Move move2 = selectRandomMove(opponentMonster);
            int damage2 = move2.calculateDamage(opponentMonster, playerMonster);
            playerMonster.updateHP(-damage2);
            moveAnimationTrainer(move2.getName());
            
            clearIconsF(); 
            setupMainB(); 
        }
        if(map.getElementAt(x, y) == move3  &&  playerMonster.getMoves().size() > 2  ) {
        	Move move = playerMonster.getMoves().get(2);
        	int damage = move.calculateDamage(playerMonster, opponentMonster);
        	moveAnimation(playerMonster.getMoves().get(2).getName());
        	playerMonster.updateHP(-damage);
        	
        	
        	Move move2 = selectRandomMove(opponentMonster);
            int damage2 = move2.calculateDamage(opponentMonster, playerMonster);
            moveAnimationTrainer(move2.getName());
            playerMonster.updateHP(-damage2);
            
            clearIconsF(); 
            setupMainB(); 
        	
        }
        if(map.getElementAt(x, y) == move4 &&  playerMonster.getMoves().size() > 3  ) {
        	Move move = playerMonster.getMoves().get(3);
        	int damage = move.calculateDamage(playerMonster, opponentMonster);
        	moveAnimation(playerMonster.getMoves().get(3).getName());
        	playerMonster.updateHP(-damage);
        	
        	Move move2 = selectRandomMove(opponentMonster);
            int damage2 = move2.calculateDamage(opponentMonster, playerMonster);
            moveAnimationTrainer(move2.getName());
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
    GImage tackleEffect = playerMonster.getBackSprite();  
    //tackleEffect.setSize(100, 100);  
    tackleEffect.setLocation(200, 460);  
    map.add(tackleEffect);

    
    final int targetX = 630;
    final int targetY = 280;

   
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
                playerMonsterSprite.setLocation(200, 460);
            }
        }
    }, 0, 30); 
    
}

private void animateFireBlast() {
    
    GImage FireBlast = new GImage("FireAttack.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(200, 460);  
    map.add(FireBlast);

    
    final int targetX = 630;
    final int targetY = 280;

   
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
                map.remove(FireBlast);
            }
        }
    }, 0, 30); 
    
}


private void animateFlamethrower() {
    
    int numFireBlasts = 25;

    final int targetX = 630;
    final int targetY = 280;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("FireAttack.png");  
        fireBlast.setSize(50, 50);  
        
        fireBlast.setLocation(200, 460);
        map.add(fireBlast);
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
                map.remove(fireBlast);  
                cancel();  
            }

          
        }
    }, 0, 30); 
}


private void animateWaterGun() {
    
    int numFireBlasts = 25;

    final int targetX = 630;
    final int targetY = 280;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("bubble.png");  
        fireBlast.setSize(50, 50);  
        
        fireBlast.setLocation(200, 460);
        map.add(fireBlast);
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


public void moveAnimationTrainer(String moveName) {
	   
    if (moveName.equals("Tackle")) {
    	animateTackleTrainer();
    } else if (moveName.equals("Ember")) {
        //animateEmber();
    } else if (moveName.equals("Flamethrower")) {
    	animateFlamethrowerTrainer();
    } else if (moveName.equals("Fire Blast")) {
    	animateFireBlastTrainer();
    } else if (moveName.equals("Water Gun")) {
    	animateWaterGunTrainer();
    } else if (moveName.equals("Surf")) {
       // animateSurf();
    } else if (moveName.equals("Thunderbolt")) {
        //animateThunderbolt();
    } else if (moveName.equals("Earthquake")) {
       // animateEarthquake();
    } 
   
}

private void animateTackleTrainer() {
    // Create the tackle effect image
    GImage tackleEffect = playerMonster.getBackSprite();  
    //tackleEffect.setSize(100, 100);  
    tackleEffect.setLocation( 630, 280);  
    map.add(tackleEffect);

    
    final int targetX = 200;
    final int targetY = 460;

   
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
                playerMonsterSprite.setLocation(200, 460);
            }
        }
    }, 0, 30); 
    
}

private void animateFireBlastTrainer() {
    
    GImage FireBlast = new GImage("FireAttack.png");  
   
    FireBlast.setSize(50, 50);
    FireBlast.setLocation(630, 280);  
    map.add(FireBlast);

    
    final int targetX = 200;
    final int targetY = 460;

   
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
                map.remove(FireBlast);
            }
        }
    }, 0, 30); 
    
}


private void animateFlamethrowerTrainer() {
    
    int numFireBlasts = 25;

    final int targetX = 200;
    final int targetY = 460;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("FireAttack.png");  
        fireBlast.setSize(50, 50);  
        
        fireBlast.setLocation(630, 280);
        map.add(fireBlast);
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


private void animateWaterGunTrainer() {
    
    int numFireBlasts = 25;

    final int targetX = 200;
    final int targetY = 460;

    final int moveDistance = 10;

    GImage[] fireBlasts = new GImage[numFireBlasts];

    for (int i = 0; i < numFireBlasts; i++) {
        GImage fireBlast = new GImage("bubble.png");  
        fireBlast.setSize(50, 50);  
        
        fireBlast.setLocation(630, 280);
        map.add(fireBlast);
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
	/*
    public static void main(String[] args) {
    	PlayerTrainer playerTrainer = new PlayerTrainer();
	    Monster playerMonster = new Monster(SpeciesType.SPIDER,5);
	    playerMonster.addmove(Move.TACKLE);
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
	*/
}